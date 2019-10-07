[network](../../index.md) / [com.github.kacso.androidcommons.network.factories](../index.md) / [NetworkExceptionFactory](index.md) / [toNetworkException](./to-network-exception.md)

# toNetworkException

`open fun toNetworkException(throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)

Overrides [INetworkExceptionFactory.toNetworkException](../-i-network-exception-factory/to-network-exception.md)

Transforms [throwable](../-i-network-exception-factory/to-network-exception.md#com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory$toNetworkException(kotlin.Throwable)/throwable) into [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)

### Parameters

`throwable` - [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) that needs to be transformed

**Return**
instance of [NetworkException](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md) that corresponds to [throwable](../-i-network-exception-factory/to-network-exception.md#com.github.kacso.androidcommons.network.factories.INetworkExceptionFactory$toNetworkException(kotlin.Throwable)/throwable)

