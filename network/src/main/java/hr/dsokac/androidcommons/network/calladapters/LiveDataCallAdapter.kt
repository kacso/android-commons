package hr.dsokac.androidcommons.network.calladapters


import androidx.lifecycle.LiveData
import hr.dsokac.androidcommons.network.factories.INetworkExceptionFactory
import hr.dsokac.androidcommons.network.models.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A Retrofit adapter that converts the Call into a [LiveData] of [ApiResponse].
 * @param R type of response
 * @param responseType  value type that this adapter uses when converting the HTTP response body to a Java
 *                      object.
 * @param networkExceptionFactory Implementation of [INetworkExceptionFactory] which will handle network errors
 *
 * */
class LiveDataCallAdapter<R>(
    private val responseType: Type,
    private val networkExceptionFactory: INetworkExceptionFactory
) : CallAdapter<R, LiveData<ApiResponse<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            postValue(ApiResponse.create(response, networkExceptionFactory))
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            postValue(ApiResponse.create(networkExceptionFactory.toNetworkException(throwable)))
                        }
                    })
                }
            }
        }
    }
}
