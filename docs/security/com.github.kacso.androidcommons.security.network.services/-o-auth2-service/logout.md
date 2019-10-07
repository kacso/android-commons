[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [OAuth2Service](index.md) / [logout](./logout.md)

# logout

`@POST("logout") abstract suspend fun logout(@Header("Authorization") token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): ResponseBody`

Performs logout of authorized user.

### Parameters

`token` - active access token

**Return**
[ResponseBody](#) representing server response

