[network](../index.md) / [com.github.kacso.androidcommons.network.models](./index.md)

## Package com.github.kacso.androidcommons.network.models

### Types

| Name | Summary |
|---|---|
| [ApiEmptyResponse](-api-empty-response/index.md) | `class ApiEmptyResponse<T> : `[`ApiResponse`](-api-response/index.md)`<`[`T`](-api-empty-response/index.md#T)`>`<br>separate class for HTTP 204 responses so that we can make ApiSuccessResponse's body non-null. |
| [ApiErrorResponse](-api-error-response/index.md) | `data class ApiErrorResponse<T> : `[`ApiResponse`](-api-response/index.md)`<`[`T`](-api-error-response/index.md#T)`>` |
| [ApiResponse](-api-response/index.md) | `sealed class ApiResponse<T>`<br>Common class used by API responses. |
| [ApiSuccessResponse](-api-success-response/index.md) | `data class ApiSuccessResponse<T> : `[`ApiResponse`](-api-response/index.md)`<`[`T`](-api-success-response/index.md#T)`>` |
