package com.github.kacso.androidcommons.network.factories

import com.github.kacso.androidcommons.network.exceptions.*
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/**
 * Default implementation of [INetworkExceptionFactory]
 *
 * @author Danijel Sokač
 */
open class NetworkExceptionFactory : INetworkExceptionFactory {
    override fun toNetworkException(throwable: Throwable): NetworkException {
        if (throwable is NetworkException)
            return throwable

        if (throwable is HttpException) {
            return when {
                isUnauthorized(throwable.code()) -> Unauthorized(throwable)
                isBadRequest(throwable.code()) -> BadRequest(throwable)
                isServerError(throwable.code()) -> ServerError(throwable)
                else -> UnexpectedError(throwable)
            }
        }
        return if (throwable is IOException) {
            RequestFailedException(throwable)
        } else {
            UnexpectedError(throwable)
        }

    }

    override fun fromHttpResponse(response: Response<*>): NetworkException {
        return when {
            isUnauthorized(response.code()) -> Unauthorized(HttpException(response))
            isBadRequest(response.code()) -> BadRequest(HttpException(response))
            isServerError(response.code()) -> ServerError(HttpException(response))
            else -> UnexpectedError(HttpException(response))
        }
    }

    private fun isUnauthorized(code: Int): Boolean = code in listOf(401, 403)
    private fun isBadRequest(code: Int): Boolean = code in 400..499
    private fun isServerError(code: Int): Boolean = code in 500..599
}