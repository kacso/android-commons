package com.github.kacso.androidcommons.security.network.interceptors

import com.github.kacso.androidcommons.logger.log
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.security.AUTHORIZATION_HEADER
import com.github.kacso.androidcommons.security.repositories.IOAuth2Repository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Authentication interceptor which handles oAuth2 protocol by intercepting all HTTP outgoing
 * requests and appending there authorization header with active access token. In case of
 * expired access token, it will automatically try to refresh token and in case of
 * successfully refreshed token, proceed with request. In case that new access token can not be
 * obtained it will throw [Unauthorized]
 *
 * @param authRepo instance of [IOAuth2Repository] to handle fetching and saving tokens
 *
 * @author Danijel Sokač
 */
class OAuth2Interceptor(
    private val authRepo: IOAuth2Repository,
    private val unauthorizedCodes: List<Int> = listOf(401, 403)
) : Interceptor {
    companion object {
        const val LOG_TAG = "OAuth2Interceptor"
    }

    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
        log(LOG_TAG, "Intercepting request")
        if (authRepo.getAccessToken().isNullOrEmpty()) throw Unauthorized()

        log(LOG_TAG, "Access token exist")
        val request = chain.request()

        var response = chain.proceed(setHeaders(request))

        log(LOG_TAG, "Request returned ${response.code()}")
        if (unauthorizedCodes.contains(response.code())) {
            val refreshToken = authRepo.getRefreshToken()

            if (!refreshToken.isNullOrEmpty()) {
                runBlocking {
                    try {
                        log(LOG_TAG, "Refreshing token")
                        authRepo.refreshToken()
                    } catch (e: Throwable) {
                        log(LOG_TAG, "Refresh token failed with following exception...")
                        e.log()
                        throw Unauthorized()
                    }
                }

                response = chain.proceed(setHeaders(request))
            } else {
                log(LOG_TAG, "Refresh token is empty. Throwing UnauthorizedException.")
                throw Unauthorized()
            }
        }

        return response
    }

    private fun setHeaders(request: Request): Request {
        var r = request
        val token = authRepo.getAccessToken()
        val tokenType = authRepo.getTokenType()

        if (!token.isNullOrEmpty()) {
            r = request.newBuilder().addHeader(AUTHORIZATION_HEADER, "$tokenType $token").build()
        }
        return r
    }
}