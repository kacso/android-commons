[network](../../index.md) / [com.github.kacso.androidcommons.network.models](../index.md) / [ApiResponse](.)

# ApiResponse

`sealed class ApiResponse<T>`

Common class used by API responses.

**Parameters**



### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <T> create(error: `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)`): `[`ApiErrorResponse`](../-api-error-response/index.md)`<T>`<br>`fun <T> create(response: <ERROR CLASS><T>, networkExceptionFactory: `[`INetworkExceptionFactory`](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md)`): ApiResponse<T>` |

### Inheritors

| Name | Summary |
|---|---|
| [ApiEmptyResponse](../-api-empty-response/index.md) | `class ApiEmptyResponse<T> : ApiResponse<T>`<br>separate class for HTTP 204 responses so that we can make ApiSuccessResponses body non-null. |
| [ApiErrorResponse](../-api-error-response/index.md) | `data class ApiErrorResponse<T> : ApiResponse<T>` |
| [ApiSuccessResponse](../-api-success-response/index.md) | `data class ApiSuccessResponse<T> : ApiResponse<T>` |
