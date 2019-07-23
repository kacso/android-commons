package hr.dsokac.androidcommons.network.repository

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import hr.dsokac.androidcommons.data.ErrorHolder
import hr.dsokac.androidcommons.data.Resource
import hr.dsokac.androidcommons.network.exceptions.NetworkException
import hr.dsokac.androidcommons.network.models.ApiEmptyResponse
import hr.dsokac.androidcommons.network.models.ApiErrorResponse
import hr.dsokac.androidcommons.network.models.ApiResponse
import hr.dsokac.androidcommons.network.models.ApiSuccessResponse

abstract class NetworkBoundResource<ResultType, RequestType>
@MainThread constructor() {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.Loading()
        @Suppress("LeakingThis")
        val dbSource = loadFromDb()
        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    setValue(Resource.Success(newData))
                }
            }
        }
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
        result.addSource(dbSource) { newData ->
            setValue(Resource.Loading(newData))
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response) {
                is ApiSuccessResponse -> {
                    saveCallResult(processResponse(response))
                    // we specially request a new live data,
                    // otherwise we will get immediately last cached value,
                    // which may not be updated with latest results received from network.
                    result.addSource(loadFromDb()) { newData ->
                        setValue(Resource.Success(newData))
                    }

                }
                is ApiEmptyResponse -> {
                    // reload from disk whatever we had
                    result.addSource(loadFromDb()) { newData ->
                        setValue(Resource.Success(newData))
                    }

                }
                is ApiErrorResponse -> {
                    val error = onFetchFailed(response.error)
                    result.addSource(dbSource) { newData ->
                        setValue(Resource.Error(error, newData))
                    }
                }
            }
        }
    }

    protected open fun onFetchFailed(error: NetworkException): ErrorHolder {
        return ErrorHolder(cause = error)
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<RequestType>) = response.body

    @WorkerThread
    protected abstract fun saveCallResult(item: RequestType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun loadFromDb(): LiveData<ResultType>

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
}