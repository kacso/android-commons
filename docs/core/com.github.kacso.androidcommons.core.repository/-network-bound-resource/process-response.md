[core](../../index.md) / [com.github.kacso.androidcommons.core.repository](../index.md) / [NetworkBoundResource](index.md) / [processResponse](./process-response.md)

# processResponse

`protected open suspend fun processResponse(response: ApiSuccessResponse<`[`RequestType`](index.md#RequestType)`>): `[`RequestType`](index.md#RequestType)

Called when network request completes with success.
Here you can process response additionally if needed.
By default, function will return [ApiSuccessResponse.body](#)

**Return**
Response from the server as [RequestType](index.md#RequestType)

