[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [RxOAuth2Service](index.md) / [logout](./logout.md)

# logout

`@POST("logout") abstract fun logout(@Header("Authorization") token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<ResponseBody>`

Performs logout of authorized user.

### Parameters

`token` - active access token

**Return**
emits [ResponseBody](#) or [NetworkException](#) in cas of an error through [Single](#)

