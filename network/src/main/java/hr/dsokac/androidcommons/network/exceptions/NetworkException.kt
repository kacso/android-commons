package hr.dsokac.androidcommons.network.exceptions

import retrofit2.Response
import java.io.IOException

/**
 * An exception which is thrown when request to server fails
 *
 * @property message description of exception
 * @property response response returned from server if exist
 * @property cause original exception thrown
 *
 * @author Danijel Sokač
 */
abstract class NetworkException(message: String?, val response: Response<*>?, cause: Throwable?) :
    IOException(message, cause) {
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is NetworkException) return false

        if (response != other.response || message != other.message
            || cause != other.cause
        ) return false

        return true
    }

    override fun hashCode(): Int {
        return response.hashCode() + message.hashCode() + cause.hashCode()
    }
}