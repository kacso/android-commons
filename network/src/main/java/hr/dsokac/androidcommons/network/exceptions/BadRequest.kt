package hr.dsokac.androidcommons.network.exceptions

import retrofit2.HttpException

/**
 * An exception which is thrown when server returns Bad request (one of 4xx codes)
 *
 * @property httpException instance of [HttpException] which contains more info about exception or null if http
 *                          exception is not available
 *
 * @author Danijel Sokač
 */
open class BadRequest(val httpException: HttpException? = null) :
    NetworkException(httpException?.response()?.errorBody()?.string(), httpException?.response(), httpException)