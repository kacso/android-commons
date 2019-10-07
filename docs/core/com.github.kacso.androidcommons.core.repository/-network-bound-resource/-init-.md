[core](../../index.md) / [com.github.kacso.androidcommons.core.repository](../index.md) / [NetworkBoundResource](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`NetworkBoundResource(scope: CoroutineScope = CoroutineScope(Dispatchers.IO))`

Abstract class which implements network retrieval and DB caching by using local database as
single source of truth as recommended by Google.

### Parameters

`ResultType` - Type of the [Resource](#) data

`RequestType` - Type of the API response

`scope` - [CoroutineScope](#) on which background work will be done. By default, scope with [Dispatchers.IO](#) is used