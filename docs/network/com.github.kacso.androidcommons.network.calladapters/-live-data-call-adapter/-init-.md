[network](../../index.md) / [com.github.kacso.androidcommons.network.calladapters](../index.md) / [LiveDataCallAdapter](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`LiveDataCallAdapter(responseType: `[`Type`](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)`, networkExceptionFactory: `[`INetworkExceptionFactory`](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md)`)`

A Retrofit adapter that converts the Call into a [LiveData](#) of [ApiResponse](../../com.github.kacso.androidcommons.network.models/-api-response/index.md).

### Parameters

`R` - type of response

`responseType` - value type that this adapter uses when converting the HTTP response body to a Java
object.

`networkExceptionFactory` - Implementation of [INetworkExceptionFactory](../../com.github.kacso.androidcommons.network.factories/-i-network-exception-factory/index.md) which will handle network errors