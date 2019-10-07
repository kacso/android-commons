[network](../../index.md) / [com.github.kacso.androidcommons.network.calladapters](../index.md) / [LiveDataCallAdapter](./index.md)

# LiveDataCallAdapter

`class LiveDataCallAdapter<R> : CallAdapter<`[`R`](index.md#R)`, LiveData<`[`ApiResponse`](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)`<`[`R`](index.md#R)`>>>`

A Retrofit adapter that converts the Call into a [LiveData](#) of [ApiResponse](../../com.github.kacso.androidcommons.network.models/-api-response/index.md).

### Parameters

`R` - type of response

`responseType` - value type that this adapter uses when converting the HTTP response body to a Java
    object.

`networkExceptionFactory` - Implementation of [INetworkExceptionFactory](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md) which will handle network errors

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LiveDataCallAdapter(responseType: `[`Type`](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)`, networkExceptionFactory: `[`INetworkExceptionFactory`](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md)`)`<br>A Retrofit adapter that converts the Call into a [LiveData](#) of [ApiResponse](../../com.github.kacso.androidcommons.network.models/-api-response/index.md). |

### Functions

| Name | Summary |
|---|---|
| [adapt](adapt.md) | `fun adapt(call: Call<`[`R`](index.md#R)`>): LiveData<`[`ApiResponse`](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)`<`[`R`](index.md#R)`>>` |
| [responseType](response-type.md) | `fun responseType(): `[`Type`](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
