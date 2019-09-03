package com.github.kacso.androidcommons.network.exceptions

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
    IOException(message, cause)