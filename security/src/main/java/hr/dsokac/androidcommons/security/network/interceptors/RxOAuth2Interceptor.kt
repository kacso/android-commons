package hr.dsokac.androidcommons.security.network.interceptors

import hr.dsokac.androidcommons.logger.log
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.security.AUTHORIZATION_HEADER
import hr.dsokac.androidcommons.security.repositories.IRxOAuth2Repository
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
 * @param authRepo instance of [IRxOAuth2Repository] to handle fetching and saving tokens
 *
 * @author Danijel Sokač
 */
class RxOAuth2Interceptor(
    private val authRepo: IRxOAuth2Repository,
    private val unauthorizedCodes: List<Int> = listOf(401, 403)
) : Interceptor {
    companion object {
        const val LOG_TAG = "RxOAuth2Interceptor"
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
                try {
                    log(LOG_TAG, "Refreshing token")
                    authRepo.refreshToken().blockingAwait()
                } catch (e: Throwable) {
                    log(LOG_TAG, "Refresh token failed with following exception...")
                    e.log()
                    throw Unauthorized()
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