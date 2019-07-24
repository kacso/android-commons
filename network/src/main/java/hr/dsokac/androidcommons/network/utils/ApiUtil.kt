package hr.dsokac.androidcommons.network.utils

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hr.dsokac.androidcommons.network.exceptions.NetworkException
import hr.dsokac.androidcommons.network.factories.INetworkExceptionFactory
import hr.dsokac.androidcommons.network.factories.NetworkExceptionFactory
import hr.dsokac.androidcommons.network.models.ApiResponse
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
