[network](../../index.md) / [com.github.kacso.androidcommons.network.calladapters](../index.md) / [LiveDataCallAdapterFactory](.)

# LiveDataCallAdapterFactory

`class LiveDataCallAdapterFactory`

Retrofit CallAdapter factory used to enable [LiveData](#) return type of [ApiResponse](../../com.github.kacso.androidcommons.network.models/-api-response/index.md)

### Parameters

`networkExceptionFactory` - Implementation of [INetworkExceptionFactory](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md) which will handle network errors

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LiveDataCallAdapterFactory(networkExceptionFactory: `[`INetworkExceptionFactory`](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md)`)`<br>Retrofit CallAdapter factory used to enable [LiveData](#) return type of [ApiResponse](../../com.github.kacso.androidcommons.network.models/-api-response/index.md) |

### Functions

| Name | Summary |
|---|---|
| [get](get.md) | `fun get(returnType: `[`Type`](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)`, annotations: Array<Annotation>, retrofit: <ERROR CLASS>): <ERROR CLASS><out <ERROR CLASS>, out <ERROR CLASS>>?` |
