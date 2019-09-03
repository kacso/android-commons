package com.github.kacso.androidcommons.network.factories

import com.github.kacso.androidcommons.network.exceptions.NetworkException
import retrofit2.Response

/**
 * Interface defining functionalities which each [INetworkExceptionFactory] needs to implement
 * in order to transform [Throwable] to [NetworkException]
 *
 * @author Danijel Sokač
 */
interface INetworkExceptionFactory {
    /**
     * Transforms [throwable] into [NetworkException]
     *
     * @param throwable [Throwable] that needs to be transformed
     *
     * @return instance of [NetworkException] that corresponds to [throwable]
     */
    fun toNetworkException(throwable: Throwable): NetworkException

    /**
     * Generates [NetworkException] from [response]
     *
     * @param response HTTP response for which [NetworkException] should be generated
     */
    fun fromHttpResponse(response: Response<*>): NetworkException
}