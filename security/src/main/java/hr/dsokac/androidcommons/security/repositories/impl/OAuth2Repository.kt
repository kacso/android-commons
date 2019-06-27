package hr.dsokac.androidcommons.security.repositories.impl

import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.preferences.ISharedPrefs
import hr.dsokac.androidcommons.security.ACCESS_TOKEN_PREFS_KEY
import hr.dsokac.androidcommons.security.REFRESH_TOKEN_PREFS_KEY
import hr.dsokac.androidcommons.security.TOKEN_TYPE_PREFS_KEY
import hr.dsokac.androidcommons.security.USERNAME_PREFS_KEY
import hr.dsokac.androidcommons.security.network.services.OAuth2Service
import hr.dsokac.androidcommons.security.repositories.IOAuth2Repository
import java.io.IOException

open class OAuth2Repository(
    private val sharedPrefs: ISharedPrefs,
    private val service: OAuth2Service,
    private val authorizationKey: String
) : IOAuth2Repository {
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
    override suspend fun login(username: String, password: String) {
        service.login(username = username, password = password, authorizationKey = authorizationKey)
            .apply {
                save(accessToken!!, refreshToken!!, tokenType!!)
                saveUsername(username)
            }
    }

    @Throws(NullPointerException::class, IOException::class)
    override suspend fun refreshToken() {
        service.refreshToken(refreshToken = getRefreshToken()!!, authorizationKey = authorizationKey)
            .apply {
                save(accessToken!!, refreshToken!!, tokenType!!)
            }
    }

    @Throws(NullPointerException::class, IOException::class)
    override suspend fun logout() {
        runCatching {
            service.logout(getAccessToken()!!)
        }.onSuccess {
            clearSession()
        }.onFailure {
            if (it is Unauthorized) {
                clearSession()
            } else {
                throw it
            }
        }
    }
}