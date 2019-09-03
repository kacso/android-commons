

### All Types

| Name | Summary |
|---|---|
| [com.github.kacso.androidcommons.network.models.ApiEmptyResponse](../com.github.kacso.androidcommons.network.models/-api-empty-response/index.md) | separate class for HTTP 204 responses so that we can make ApiSuccessResponses body non-null. |
| [com.github.kacso.androidcommons.network.models.ApiErrorResponse](../com.github.kacso.androidcommons.network.models/-api-error-response/index.md) |  |
| [com.github.kacso.androidcommons.network.models.ApiResponse](../com.github.kacso.androidcommons.network.models/-api-response/index.md) | Common class used by API responses. |
| [com.github.kacso.androidcommons.network.models.ApiSuccessResponse](../com.github.kacso.androidcommons.network.models/-api-success-response/index.md) |  |
| [com.github.kacso.androidcommons.network.utils.ApiUtil](../com.github.kacso.androidcommons.network.utils/-api-util/index.md) |  |
| [com.github.kacso.androidcommons.network.exceptions.BadRequest](../com.github.kacso.androidcommons.network.exceptions/-bad-request/index.md) | An exception which is thrown when server returns Bad request (one of 4xx codes) |
| [com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory](../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md) | Interface defining functionalities which each [INetworkExceptionFactory](../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md) needs to implement
in order to transform [Throwable](#) to [NetworkException](../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) |
| [com.github.kacso.androidcommons.network.calladapters.LiveDataCallAdapter](../com.github.kacso.androidcommons.network.calladapters/-live-data-call-adapter/index.md) | A Retrofit adapter that converts the Call into a [LiveData](#) of [ApiResponse](../com.github.kacso.androidcommons.network.models/-api-response/index.md). |
| [com.github.kacso.androidcommons.network.calladapters.LiveDataCallAdapterFactory](../com.github.kacso.androidcommons.network.calladapters/-live-data-call-adapter-factory/index.md) | Retrofit CallAdapter factory used to enable [LiveData](#) return type of [ApiResponse](../com.github.kacso.androidcommons.network.models/-api-response/index.md) |
| [com.github.kacso.androidcommons.network.exceptions.NetworkException](../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) | An exception which is thrown when request to server fails |
| [com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory](../com.github.kacso.androidcommons.network.factories/-network-exception-factory/index.md) | Default implementation of [INetworkExceptionFactory](../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md) |
| [com.github.kacso.androidcommons.network.interceptors.NetworkExceptionInterceptor](../com.github.kacso.androidcommons.network.interceptors/-network-exception-interceptor/index.md) | OkHttp interceptor which which throws appropriate exceptions base on HTTP status code if there was ony error
during network call. Otherwise, server response is returned. |
| [com.github.kacso.androidcommons.network.exceptions.RequestFailedException](../com.github.kacso.androidcommons.network.exceptions/-request-failed-exception/index.md) | An exception which is thrown when server request fails due to connection issues (e.g. no internet service or
timeout occurs) |
| [com.github.kacso.androidcommons.network.exceptions.ServerError](../com.github.kacso.androidcommons.network.exceptions/-server-error/index.md) | An exception which is thrown when server returns Server error (one of 5xx codes) |
| [com.github.kacso.androidcommons.network.exceptions.Unauthorized](../com.github.kacso.androidcommons.network.exceptions/-unauthorized/index.md) | An exception which is thrown when server returns Unauthorized (e.g. 401 or 403) |
| [com.github.kacso.androidcommons.network.exceptions.UnexpectedError](../com.github.kacso.androidcommons.network.exceptions/-unexpected-error/index.md) | Exception thrown when there has happen some error during network call, but that error does not
belong to any other well known exception |
