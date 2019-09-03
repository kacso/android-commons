package com.github.kacso.androidcommons.security.repositories.impl

import android.util.Log
import com.github.kacso.androidcommons.logger.log
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.preferences.ISharedPrefs
import com.github.kacso.androidcommons.security.ACCESS_TOKEN_PREFS_KEY
import com.github.kacso.androidcommons.security.REFRESH_TOKEN_PREFS_KEY
import com.github.kacso.androidcommons.security.TOKEN_TYPE_PREFS_KEY
import com.github.kacso.androidcommons.security.USERNAME_PREFS_KEY
import com.github.kacso.androidcommons.security.network.services.OAuth2Service
import com.github.kacso.androidcommons.security.repositories.IOAuth2Repository
import java.io.IOException

open class OAuth2Repository(
    private val sharedPrefs: ISharedPrefs,
    private val service: OAuth2Service,
    private val authorizationKey: String
) : IOAuth2Repository {
    companion object {
        const val LOG_TAG = "OAuth2Repository"
    }

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
        log(LOG_TAG, "Username $username saved")
    }

    override fun clearSession() {
        sharedPrefs.removeKey(ACCESS_TOKEN_PREFS_KEY)
        sharedPrefs.removeKey(REFRESH_TOKEN_PREFS_KEY)
        sharedPrefs.removeKey(TOKEN_TYPE_PREFS_KEY)
        sharedPrefs.removeKey(USERNAME_PREFS_KEY)
        log(LOG_TAG, "Session cleared")
    }

    override fun getUsername(): String? = sharedPrefs.read(USERNAME_PREFS_KEY, null as String?)

    @Throws(NullPointerException::class, IOException::class)
    override suspend fun login(username: String, password: String) {
        runCatching {
            service.login(username = username, password = password, authorizationKey = authorizationKey)
                .apply {
                    save(accessToken!!, refreshToken!!, tokenType!!)
                    saveUsername(username)
                }
        }.onSuccess {
            log(LOG_TAG, "Login finished successfully")
        }.onFailure {
            log(Log.WARN, LOG_TAG, "Login failed")
            throw it
        }
    }

    @Throws(NullPointerException::class, IOException::class)
    override suspend fun refreshToken() {
        runCatching {
            service.refreshToken(refreshToken = getRefreshToken()!!, authorizationKey = authorizationKey)
                .apply {
                    save(accessToken!!, refreshToken!!, tokenType!!)
                }
        }.onSuccess {
            log(LOG_TAG, "Token refreshed successfully")
        }.onFailure {
            log(Log.WARN, LOG_TAG, "Refresh token failed")
            throw it
        }
    }

    @Throws(NullPointerException::class, IOException::class)
    override suspend fun logout() {
        runCatching {
            service.logout(getAuthorizationHeader())
        }.onSuccess {
            log(LOG_TAG, "Logout completed successfully.")
            log(LOG_TAG, "Clearing session...")
            clearSession()
        }.onFailure {
            if (it is Unauthorized) {
                log(LOG_TAG, "Logout failed with Unauthorized.")
                log(LOG_TAG, "Clearing session...")
                clearSession()
            } else {
                log(Log.WARN, LOG_TAG, "Logout failed.")
                throw it
            }
        }
    }
}