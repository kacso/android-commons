[network](../../index.md) / [com.github.kacso.androidcommons.network.factories](../index.md) / [INetworkExceptionFactory](./index.md)

# INetworkExceptionFactory

`interface INetworkExceptionFactory`

Interface defining functionalities which each [INetworkExceptionFactory](./index.md) needs to implement
in order to transform [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) to [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [fromHttpResponse](from-http-response.md) | `abstract fun fromHttpResponse(response: Response<*>): `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)<br>Generates [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) from [response](from-http-response.md#com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory$fromHttpResponse(retrofit2.Response((kotlin.Any)))/response) |
| [toNetworkException](to-network-exception.md) | `abstract fun toNetworkException(throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)<br>Transforms [throwable](to-network-exception.md#com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory$toNetworkException(kotlin.Throwable)/throwable) into [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) |

### Inheritors

| Name | Summary |
|---|---|
| [NetworkExceptionFactory](../-network-exception-factory/index.md) | `open class NetworkExceptionFactory : `[`INetworkExceptionFactory`](./index.md)<br>Default implementation of [INetworkExceptionFactory](./index.md) |
