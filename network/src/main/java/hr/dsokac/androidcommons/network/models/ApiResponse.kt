package hr.dsokac.androidcommons.network.models

import hr.dsokac.androidcommons.network.exceptions.NetworkException
import hr.dsokac.androidcommons.network.extensions.toMap
import hr.dsokac.androidcommons.network.factories.INetworkExceptionFactory
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
                if (body == null) {
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
class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(
    val body: T,
    val headers: Map<String, String?>
) : ApiResponse<T>() {
    constructor(body: T, headers: Headers?) : this(
        body = body,
        headers = headers?.toMap() ?: emptyMap()
    )
}

data class ApiErrorResponse<T>(val error: NetworkException) : ApiResponse<T>()