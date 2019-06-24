package hr.dsokac.androidcommons.network.exceptions

import retrofit2.HttpException

/**
 * An exception which is thrown when server returns Unauthorized (e.g. 401 or 403)
 *
 * @property httpException instance of [HttpException] which contains more info about exception or null if http
 *                          exception is not available
 *
 * @author Danijel Sokač
 */
open class Unauthorized(val httpException: HttpException? = null) :
    NetworkException("Unauthorized", httpException?.response(), httpException)
