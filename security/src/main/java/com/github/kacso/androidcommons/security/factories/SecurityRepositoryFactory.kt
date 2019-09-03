package com.github.kacso.androidcommons.security.factories

import android.content.Context
import android.util.Log
import com.github.kacso.androidcommons.logger.log
import com.github.kacso.androidcommons.network.interceptors.NetworkExceptionInterceptor
import com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory
import com.github.kacso.androidcommons.security.CONNECT_TIMEOUT_SECS
import com.github.kacso.androidcommons.security.READ_TIMEOUT_SECS
import com.github.kacso.androidcommons.security.SECURITY_PREFS
import com.github.kacso.androidcommons.security.network.managers.OAuth2NetworkManager
import com.github.kacso.androidcommons.security.repositories.IOAuth2Repository
import com.github.kacso.androidcommons.security.repositories.IRxOAuth2Repository
import com.github.kacso.androidcommons.security.repositories.impl.OAuth2Repository
import com.github.kacso.androidcommons.security.repositories.impl.RxOAuth2Repository

/**
 * Factory class which generates repositories available in security module
 *
 * @author Danijel Sokač
 */
object SecurityRepositoryFactory {
    private const val LOG_TAG = "SecurityRepositoryFactory"
    private var oAuth2Repositories: MutableMap<String, IOAuth2Repository> = HashMap()
    private var rxOAuth2Repositories: MutableMap<String, IRxOAuth2Repository> = HashMap()

    /**
     * Obtain instance of [IOAuth2Repository]. This method will ensure that there is
     * always only one instance of [IOAuth2Repository] created for same [baseUrl].
     *
     * @param baseUrl basic part of authorization server URL. For example: https://192.168.112:8080/security/
     * @param authorizationKey key which will identify app requests on authorization server
     *                         For example: Basic Aycx21312easdxyxyxcyxdcasdfw3
     * @param connectionTimeoutSecs maximum waiting time for connection to establish
     * @param readTimeoutSecs maximum waiting time for server to return response
     * @param networkExceptionInterceptor instance of [NetworkExceptionInterceptor] which will convert errors, or null
     *                          if such interceptor is not needed
     *
     * @return instance of [IOAuth2Repository]
     */
    @Synchronized
    fun getOAuth2Repository(
        context: Context,
        baseUrl: String,
        authorizationKey: String,
        connectionTimeoutSecs: Long = CONNECT_TIMEOUT_SECS,
        readTimeoutSecs: Long = READ_TIMEOUT_SECS,
        networkExceptionInterceptor: NetworkExceptionInterceptor? = null
    ): IOAuth2Repository {
        var rep = oAuth2Repositories[baseUrl]
        if (rep != null) {
            log(Log.VERBOSE, LOG_TAG, "Reusing oAuth2Repository")
            return rep
        } else {
            log(Log.VERBOSE, LOG_TAG, "Creating new oAuth2Repository")
            rep = OAuth2Repository(
                authorizationKey = authorizationKey,
                sharedPrefs = SharedPrefsFactory.getSharedPrefs(context, SECURITY_PREFS),
                service = OAuth2NetworkManager(
                    baseUrl,
                    connectionTimeoutSecs,
                    readTimeoutSecs,
                    networkExceptionInterceptor
                ).restService
            )
            oAuth2Repositories[baseUrl] = rep

            return rep
        }
    }

    /**
     * Obtain instance of [IRxOAuth2Repository]. This method will ensure that there is
     * always only one instance of [IRxOAuth2Repository] created.
     *
     * @param baseUrl basic part of authorization server URL. For example: https://192.168.112:8080/security/
     * @param authorizationKey key which will identify app requests on authorization server
     *                         For example: Basic Aycx21312easdxyxyxcyxdcasdfw3
     * @param connectionTimeoutSecs maximum waiting time for connection to establish
     * @param readTimeoutSecs maximum waiting time for server to return response
     * @param networkExceptionInterceptor instance of [NetworkExceptionInterceptor] which will convert errors, or null
     *                          if such interceptor is not needed
     *
     * @return instance of [IRxOAuth2Repository]
     */
    @Synchronized
    fun getRxOAuth2Repository(
        context: Context,
        baseUrl: String,
        authorizationKey: String,
        connectionTimeoutSecs: Long = CONNECT_TIMEOUT_SECS,
        readTimeoutSecs: Long = READ_TIMEOUT_SECS,
        networkExceptionInterceptor: NetworkExceptionInterceptor? = null
    ): IRxOAuth2Repository {
        var rep = rxOAuth2Repositories[baseUrl]
        if (rep != null) {
            log(Log.VERBOSE, LOG_TAG, "Reusing rxOAuth2Repository")
            return rep
        } else {
            log(Log.VERBOSE, LOG_TAG, "Creating new RxOAuth2Repository")
            rep = RxOAuth2Repository(
                authorizationKey = authorizationKey,
                sharedPrefs = SharedPrefsFactory.getSharedPrefs(context, SECURITY_PREFS),
                service = OAuth2NetworkManager(
                    baseUrl,
                    connectionTimeoutSecs,
                    readTimeoutSecs,
                    networkExceptionInterceptor
                ).rxService
            )
            rxOAuth2Repositories[baseUrl] = rep

            return rep
        }
    }
}