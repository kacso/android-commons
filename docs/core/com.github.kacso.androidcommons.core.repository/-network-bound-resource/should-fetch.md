[core](../../index.md) / [com.github.kacso.androidcommons.core.repository](../index.md) / [NetworkBoundResource](index.md) / [shouldFetch](./should-fetch.md)

# shouldFetch

`protected open fun shouldFetch(data: `[`ResultType`](index.md#ResultType)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Determine if network request should be performed or data from DB is valid to use.
By default, only if [data](should-fetch.md#com.github.kacso.androidcommons.core.repository.NetworkBoundResource$shouldFetch(com.github.kacso.androidcommons.core.repository.NetworkBoundResource.ResultType)/data) is null, request will be performed

### Parameters

`data` - Current version of data from local database. Null if there is no data.

**Return**
True is network request should be performed, false otherwise

