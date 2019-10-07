[network](../../index.md) / [com.github.kacso.androidcommons.network.factories](../index.md) / [NetworkExceptionFactory](./index.md)

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
| [fromHttpResponse](from-http-response.md) | `open fun fromHttpResponse(response: Response<*>): `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)<br>Generates [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) from [response](../-i-network-exception-factory/from-http-response.md#com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory$fromHttpResponse(retrofit2.Response((kotlin.Any)))/response) |
| [toNetworkException](to-network-exception.md) | `open fun toNetworkException(throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)<br>Transforms [throwable](../-i-network-exception-factory/to-network-exception.md#com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory$toNetworkException(kotlin.Throwable)/throwable) into [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) |
