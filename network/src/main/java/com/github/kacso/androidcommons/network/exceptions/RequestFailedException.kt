package com.github.kacso.androidcommons.network.exceptions

import java.io.IOException

/**
 * An exception which is thrown when server request fails due to connection issues (e.g. no internet service or
 * timeout occurs)
 *
 * @property ioException instance of [IOException] which contains more info about exception or null if http
 *                          exception is not available
 *
 * @author Danijel Sokač
 */
open class RequestFailedException(val ioException: IOException? = null) :
    NetworkException(ioException?.message, null, ioException)