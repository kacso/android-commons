package hr.dsokac.androidcommons.core.repository

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

/**
 * Abstract class which implements network retrieval and DB caching by using local database as
 * single source of truth as recommended by Google.
 *
 * @param ResultType Type of the [Resource] data
 * @param RequestType Type of the API response
 */
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

    /**
     * Called when network request fails with an [NetworkException].
     * Override this function in case that you need to extract server response and share it with view.
     * By default, function will only mask this error into [ErrorHolder]
     *
     * @return [ErrorHolder] containing error and messages for view
     */
    protected open fun onFetchFailed(error: NetworkException): ErrorHolder {
        return ErrorHolder(cause = error)
    }

    /**
     * Get requested data as [LiveData]
     */
    fun asLiveData() = result as LiveData<Resource<ResultType>>

    /**
     * Called when network request completes with success.
     * Here you can process response additionally if needed.
     * By default, function will return [ApiSuccessResponse.body]
     *
     * @return Response from the server as [RequestType]
     */
    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<RequestType>) = response.body

    /**
     * Save server response to the DB
     *
     * @param item server response
     */
    @WorkerThread
    protected abstract fun saveCallResult(item: RequestType)

    /**
     * Determine if network request should be performed or data from DB is valid to use.
     * By default, only if [data] is null, request will be performed
     *
     * @param data Current version of data from local database. Null if there is no data.
     *
     * @return True is network request should be performed, false otherwise
     */
    @MainThread
    protected open fun shouldFetch(data: ResultType?): Boolean = data == null

    /**
     * Read data from local database
     *
     * @return [LiveData] which emit [ResultType]
     */
    @MainThread
    protected abstract fun loadFromDb(): LiveData<ResultType>

    /**
     * Perform network call which will retrieve data
     *
     * @return [LiveData] of [ApiResponse] containing network response
     */
    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
}