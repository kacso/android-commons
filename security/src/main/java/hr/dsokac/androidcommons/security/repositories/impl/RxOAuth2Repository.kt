package hr.dsokac.androidcommons.security.repositories.impl

import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.preferences.ISharedPrefs
import hr.dsokac.androidcommons.security.ACCESS_TOKEN_PREFS_KEY
import hr.dsokac.androidcommons.security.REFRESH_TOKEN_PREFS_KEY
import hr.dsokac.androidcommons.security.TOKEN_TYPE_PREFS_KEY
import hr.dsokac.androidcommons.security.USERNAME_PREFS_KEY
import hr.dsokac.androidcommons.security.network.services.RxOAuth2Service
import hr.dsokac.androidcommons.security.repositories.IRxOAuth2Repository
import io.reactivex.Completable
import io.reactivex.Single
import java.io.IOException

open class RxOAuth2Repository(
    private val sharedPrefs: ISharedPrefs,
    private val service: RxOAuth2Service,
    private val authorizationKey: String
) : IRxOAuth2Repository {
    override fun getAccessToken(): String? = sharedPrefs.read(ACCESS_TOKEN_PREFS_KEY, null as String?)

    override fun getRefreshToken(): String? = sharedPrefs.read(REFRESH_TOKEN_PREFS_KEY, null as String?)

    override fun getTokenType(): String? = sharedPrefs.read(TOKEN_TYPE_PREFS_KEY, null as String?)

    override fun save(accessToken: String, refreshToken: String, tokenType: String) {
        sharedPrefs.write(ACCESS_TOKEN_PREFS_KEY, accessToken)
        sharedPrefs.write(REFRESH_TOKEN_PREFS_KEY, refreshToken)
        sharedPrefs.write(TOKEN_TYPE_PREFS_KEY, tokenType)
    }

    override fun saveUsername(username: String) {
        sharedPrefs.write(USERNAME_PREFS_KEY, username)
    }

    override fun clearSession() {
        sharedPrefs.removeKey(ACCESS_TOKEN_PREFS_KEY)
        sharedPrefs.removeKey(REFRESH_TOKEN_PREFS_KEY)
        sharedPrefs.removeKey(TOKEN_TYPE_PREFS_KEY)
        sharedPrefs.removeKey(USERNAME_PREFS_KEY)
    }

    override fun getUsername(): String? = sharedPrefs.read(USERNAME_PREFS_KEY, null as String?)

    @Throws(NullPointerException::class, IOException::class)
    override fun login(username: String, password: String): Completable {
        return service.login(username = username, password = password, authorizationKey = authorizationKey)
            .map {
                save(it.accessToken!!, it.refreshToken!!, it.tokenType!!)
                saveUsername(username)
            }
            .ignoreElement()
    }

    @Throws(NullPointerException::class, IOException::class)
    override fun refreshToken(): Completable {
        return service.refreshToken(refreshToken = getRefreshToken()!!, authorizationKey = authorizationKey)
            .map {
                save(it.accessToken!!, it.refreshToken!!, it.tokenType!!)
            }
            .ignoreElement()
    }

    @Throws(NullPointerException::class, IOException::class)
    override fun logout(): Completable {
        return service.logout(getAccessToken()!!)
            .map { clearSession() }
            .onErrorResumeNext {
                if (it is Unauthorized) {
                    Single.just(clearSession())
                } else {
                    Single.error(it)
                }
            }
            .ignoreElement()
    }
}