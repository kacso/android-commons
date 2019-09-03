[network](../../index.md) / [com.github.kacso.androidcommons.network.utils](../index.md) / [ApiUtil](.)

# ApiUtil

`object ApiUtil`

### Functions

| Name | Summary |
|---|---|
| [createCall](create-call.md) | `fun <T : Any> createCall(response: <ERROR CLASS><T>, networkExceptionFactory: `[`INetworkExceptionFactory`](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md)`): <ERROR CLASS><`[`ApiResponse`](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)`<T>>` |
| [errorCall](error-call.md) | `fun <T : Any> errorCall(networkException: `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)`): <ERROR CLASS><`[`ApiResponse`](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)`<T>>` |
| [successCall](success-call.md) | `fun <T : Any> successCall(data: T): <ERROR CLASS>` |
