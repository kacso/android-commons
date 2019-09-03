[core](../../index.md) / [com.github.kacso.androidcommons.core.repository](../index.md) / [NetworkBoundResource](.)

# NetworkBoundResource

`abstract class NetworkBoundResource<ResultType, RequestType>`

Abstract class which implements network retrieval and DB caching by using local database as
single source of truth as recommended by Google.

### Parameters

`ResultType` - Type of the [Resource](#) data

`RequestType` - Type of the API response

`scope` - [CoroutineScope](#) on which background work will be done. By default, scope with [Dispatchers.IO](#) is used

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkBoundResource(scope: <ERROR CLASS> = CoroutineScope(Dispatchers.IO))`<br>Abstract class which implements network retrieval and DB caching by using local database as
single source of truth as recommended by Google. |

### Functions

| Name | Summary |
|---|---|
| [asLiveData](as-live-data.md) | `fun asLiveData(): <ERROR CLASS><<ERROR CLASS><ResultType>>`<br>Get requested data as [LiveData](#) |
| [createCall](create-call.md) | `abstract fun createCall(): <ERROR CLASS><<ERROR CLASS><RequestType>>`<br>Perform network call which will retrieve data |
| [loadFromDb](load-from-db.md) | `abstract fun loadFromDb(): <ERROR CLASS><ResultType>`<br>Read data from local database |
| [onFetchFailed](on-fetch-failed.md) | `open fun onFetchFailed(error: <ERROR CLASS>): <ERROR CLASS>`<br>Called when network request fails with an [NetworkException](#).
Override this function in case that you need to extract server response and share it with view.
By default, function will only mask this error into [ErrorHolder](#) |
| [processResponse](process-response.md) | `fun processResponse(response: <ERROR CLASS><RequestType>): <ERROR CLASS>` |
| [saveCallResult](save-call-result.md) | `fun saveCallResult(item: RequestType): Unit` |
| [shouldFetch](should-fetch.md) | `open fun shouldFetch(data: ResultType?): Boolean`<br>Determine if network request should be performed or data from DB is valid to use.
By default, only if [data](should-fetch.md#com.github.kacso.androidcommons.core.repository.NetworkBoundResource$shouldFetch(com.github.kacso.androidcommons.core.repository.NetworkBoundResource.ResultType)/data) is null, request will be performed |
