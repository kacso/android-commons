[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [RxOAuth2Service](./index.md)

# RxOAuth2Service

`interface RxOAuth2Service`

Network service which handles user authorization requests

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [login](login.md) | `abstract fun login(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, grantType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "password", authorizationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<`[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md)`>`<br>Perform user login request. If successful, [OAuth2LoginResponse](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) will be returned through [Single](#). In case of an error appropriate [NetworkException](#) will be thrown. |
| [logout](logout.md) | `abstract fun logout(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<ResponseBody>`<br>Performs logout of authorized user. |
| [refreshToken](refresh-token.md) | `abstract fun refreshToken(refreshToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, grantType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "refresh_token", authorizationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<`[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md)`>`<br>Performs access token refresh. If successful, it will return new tokens, otherwise [NetworkException](#) will be thrown. |
