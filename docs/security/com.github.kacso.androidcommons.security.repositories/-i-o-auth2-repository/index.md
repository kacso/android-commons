[security](../../index.md) / [com.github.kacso.androidcommons.security.repositories](../index.md) / [IOAuth2Repository](./index.md)

# IOAuth2Repository

`interface IOAuth2Repository`

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
| [login](login.md) | `abstract suspend fun login(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Authorize user according to provided credentials |
| [logout](logout.md) | `abstract suspend fun logout(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Notify server that user wants to logout from system |
| [refreshToken](refresh-token.md) | `abstract suspend fun refreshToken(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Refresh access token according to oAuth2 standard |
| [save](save.md) | `abstract fun save(accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, refreshToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, tokenType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Save tokens assign to newly created session |
| [saveUsername](save-username.md) | `abstract fun saveUsername(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves username of authorized user |

### Inheritors

| Name | Summary |
|---|---|
| [OAuth2Repository](../../com.github.kacso.androidcommons.security.repositories.impl/-o-auth2-repository/index.md) | `open class OAuth2Repository : `[`IOAuth2Repository`](./index.md) |
