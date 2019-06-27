package hr.dsokac.androidcommons.security.network.interceptors

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

    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
//        log("OAuth2Interceptor", "Intercepting request")
        if (authRepo.getAccessToken().isNullOrEmpty()) throw Unauthorized()

//        log("OAuth2Interceptor", "Access token exist")
        val request = chain.request()

        var response = chain.proceed(setHeaders(request))

//        log("OAuth2Interceptor", "Request returned ${response.code()}")
        if (unauthorizedCodes.contains(response.code())) {
            val refreshToken = authRepo.getRefreshToken()

            if (!refreshToken.isNullOrEmpty()) {
                try {
//                    log("OAuth2Interceptor", "Refreshing token")
                    authRepo.refreshToken().blockingAwait()
                } catch (e: Throwable) {
//                    log("OAuth2Interceptor", "Refresh token failed with following exception...")
//                    e.log()
                    throw Unauthorized()
                }


                response = chain.proceed(setHeaders(request))
            } else {
//                log("OAuth2Interceptor", "Refresh token is empty. Throwing UnauthorizedException.")
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
//        log("OAuth2Interceptor", "Settings Auth header to $tokenType $token")
        return r
    }
}