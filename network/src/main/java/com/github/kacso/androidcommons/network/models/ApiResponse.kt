package com.github.kacso.androidcommons.network.models

import com.github.kacso.androidcommons.network.exceptions.NetworkException
import com.github.kacso.androidcommons.network.extensions.toMap
import com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory
import okhttp3.Headers
import retrofit2.Response

/**
 * Common class used by API responses.
 * @param <T> the type of the response object
</T> */
sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: NetworkException): ApiErrorResponse<T> {
            return ApiErrorResponse(error)
        }

        fun <T> create(
            response: Response<T>,
            networkExceptionFactory: INetworkExceptionFactory
        ): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                } else {
                    ApiSuccessResponse(
                        body = body,
                        headers = response.headers()
                    )
                }
            } else {
                ApiErrorResponse(networkExceptionFactory.fromHttpResponse(response))
            }
        }
    }
}

/**
 * separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null.
 */
class ApiEmptyResponse<T> : ApiResponse<T>() {
    //All empty responses are considered equal
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is ApiEmptyResponse<*>) return false

        return true
    }

    override fun hashCode(): Int {
        return 1
    }
}

data class ApiSuccessResponse<T>(
    val body: T,
    val headers: Map<String, String?>
) : ApiResponse<T>() {
    constructor(body: T, headers: Headers?) : this(
        body = body,
        headers = headers?.toMap() ?: emptyMap()
    )

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is ApiSuccessResponse<*>) return false

        if (body != other.body || headers != other.headers) return false

        return true
    }

    override fun hashCode(): Int {
        return body.hashCode() + headers.hashCode()
    }
}

data class ApiErrorResponse<T>(val error: NetworkException) : ApiResponse<T>() {
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is ApiErrorResponse<*>) return false

        if (error != other.error) return false

        return true
    }

    override fun hashCode(): Int {
        return error.hashCode()
    }
}