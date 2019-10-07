[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [OAuth2Service](index.md) / [refreshToken](./refresh-token.md)

# refreshToken

`@FormUrlEncoded @POST("token") abstract suspend fun refreshToken(@Field("refresh_token") refreshToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Field("grant_type") grantType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "refresh_token", @Header("Authorization") authorizationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md)

Performs access token refresh. If successful, it will return new tokens, otherwise
[NetworkException](#) will be thrown.

### Parameters

`refreshToken` - refresh token return by server during access token retrieval

`grantType` - for this type of request, default is refresh_token

`authorizationKey` - key issued by server which authorizes access for this app

**Return**
[OAuth2LoginResponse](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) or throws [NetworkException](#) in case of an error

