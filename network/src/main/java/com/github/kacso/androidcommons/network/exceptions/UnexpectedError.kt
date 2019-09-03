package com.github.kacso.androidcommons.network.exceptions

/**
 * Exception thrown when there has happen some error during network call, but that error does not
 * belong to any other well known exception
 *
 * @property cause original exception
 *
 * @author Danijel Sokač
 */
class UnexpectedError(cause: Throwable? = null) : NetworkException(cause?.message, null, cause)