[security](../../index.md) / [com.github.kacso.androidcommons.security.repositories](../index.md) / [IRxOAuth2Repository](./index.md)

# IRxOAuth2Repository

`interface IRxOAuth2Repository`

Interface defining functionalities which subclasses need to implement in order to handle
oAuth2 authorization and other authorization information

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [clearSession](clear-session.md) | `abstract fun clearSession(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Clears all session data (such as access token, username, etc.) when user has been logged out |
| [getAccessToken](get-access-token.md) | `abstract fun getAccessToken(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Retrieve active access token assigned for active session |
| [getAuthorizationHeader](get-authorization-header.md) | `open fun getAuthorizationHeader(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Generates authorization header value by combining token type and token value |
| [getRefreshToken](get-refresh-token.md) | `abstract fun getRefreshToken(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Retrieve active refresh token assign for active session |
| [getTokenType](get-token-type.md) | `abstract fun getTokenType(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Retrieve token type (e.g. Bearer) used for user authorization |
| [getUsername](get-username.md) | `abstract fun getUsername(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Retrieve username of authorized user |
| [login](login.md) | `abstract fun login(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Completable`<br>Authorize user according to provided credentials |
| [logout](logout.md) | `abstract fun logout(): Completable`<br>Notify server that user wants to logout from system |
| [refreshToken](refresh-token.md) | `abstract fun refreshToken(): Completable`<br>Refresh access token according to oAuth2 standard |
| [save](save.md) | `abstract fun save(accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, refreshToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, tokenType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Save tokens assign to newly created session |
| [saveUsername](save-username.md) | `abstract fun saveUsername(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves username of authorized user |

### Inheritors

| Name | Summary |
|---|---|
| [RxOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories.impl/-rx-o-auth2-repository/index.md) | `open class RxOAuth2Repository : `[`IRxOAuth2Repository`](./index.md) |
