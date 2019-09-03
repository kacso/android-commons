[network](../../index.md) / [com.github.kacso.androidcommons.network.interceptors](../index.md) / [NetworkExceptionInterceptor](.)

# NetworkExceptionInterceptor

`class NetworkExceptionInterceptor`

OkHttp interceptor which which throws appropriate exceptions base on HTTP status code if there was ony error
during network call. Otherwise, server response is returned.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkExceptionInterceptor(networkExceptionFactory: `[`INetworkExceptionFactory`](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md)`)`<br>OkHttp interceptor which which throws appropriate exceptions base on HTTP status code if there was ony error
during network call. Otherwise, server response is returned. |

### Functions

| Name | Summary |
|---|---|
| [intercept](intercept.md) | `fun intercept(chain: <ERROR CLASS>): <ERROR CLASS>` |
