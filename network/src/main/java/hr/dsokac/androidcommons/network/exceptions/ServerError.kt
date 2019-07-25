package hr.dsokac.androidcommons.network.exceptions

import retrofit2.HttpException

/**
 * An exception which is thrown when server returns Server error (one of 5xx codes)
 *
 * @property httpException instance of [HttpException] which contains more info about exception or null if http
 *                          exception is not available
 *
 * @author Danijel Sokač
 */
open class ServerError(val httpException: HttpException? = null) :
    NetworkException(httpException?.response()?.errorBody()?.string(), httpException?.response(), httpException)