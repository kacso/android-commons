[network](../../index.md) / [com.github.kacso.androidcommons.network.factories](../index.md) / [NetworkExceptionFactory](.)

# NetworkExceptionFactory

`open class NetworkExceptionFactory : `[`INetworkExceptionFactory`](../-i-network-exception-factory/index.md)

Default implementation of [INetworkExceptionFactory](../-i-network-exception-factory/index.md)

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkExceptionFactory()`<br>Default implementation of [INetworkExceptionFactory](../-i-network-exception-factory/index.md) |

### Functions

| Name | Summary |
|---|---|
| [fromHttpResponse](from-http-response.md) | `open fun fromHttpResponse(response: <ERROR CLASS><out <ERROR CLASS>>): `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)<br>Generates [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) from [response](from-http-response.md#com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory$fromHttpResponse((()))/response) |
| [toNetworkException](to-network-exception.md) | `open fun toNetworkException(throwable: Throwable): `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)<br>Transforms [throwable](to-network-exception.md#com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory$toNetworkException(kotlin.Throwable)/throwable) into [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) |
