[network](../../index.md) / [com.github.kacso.androidcommons.network.utils](../index.md) / [ApiUtil](./index.md)

# ApiUtil

`object ApiUtil`

### Functions

| Name | Summary |
|---|---|
| [createCall](create-call.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> createCall(response: Response<`[`T`](create-call.md#T)`>, networkExceptionFactory: `[`INetworkExceptionFactory`](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md)`): LiveData<`[`ApiResponse`](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)`<`[`T`](create-call.md#T)`>>` |
| [errorCall](error-call.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> errorCall(networkException: `[`NetworkException`](../../com.github.kacso.androidcommons.network.exceptions/-network-exception/index.md)`): LiveData<`[`ApiResponse`](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)`<`[`T`](error-call.md#T)`>>` |
| [successCall](success-call.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> successCall(data: `[`T`](success-call.md#T)`): LiveData<`[`ApiResponse`](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)`<`[`T`](success-call.md#T)`>>` |
