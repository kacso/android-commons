package com.github.kacso.androidcommons.network.utils

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.kacso.androidcommons.network.exceptions.NetworkException
import com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory
import com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory
import com.github.kacso.androidcommons.network.models.ApiResponse
import retrofit2.Response

@VisibleForTesting
object ApiUtil {
    @VisibleForTesting
    fun <T : Any> successCall(data: T) = createCall(Response.success(data), NetworkExceptionFactory())

    @VisibleForTesting
    fun <T : Any> errorCall(networkException: NetworkException) =
        MutableLiveData<ApiResponse<T>>().apply {
            value = ApiResponse.create(networkException)
        } as LiveData<ApiResponse<T>>

    @VisibleForTesting
    fun <T : Any> createCall(response: Response<T>, networkExceptionFactory: INetworkExceptionFactory) =
        MutableLiveData<ApiResponse<T>>().apply {
            value = ApiResponse.create(response, networkExceptionFactory)
        } as LiveData<ApiResponse<T>>
}
