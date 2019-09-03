[security](../../index.md) / [com.github.kacso.androidcommons.security.repositories](../index.md) / [IOAuth2Repository](.)

# IOAuth2Repository

`interface IOAuth2Repository`

Interface defining functionalities which subclasses need to implement in order to handle
oAuth2 authorization and other authorization information

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [clearSession](clear-session.md) | `abstract fun clearSession(): Unit`<br>Clears all session data (such as access token, username, etc.) when user has been logged out |
| [getAccessToken](get-access-token.md) | `abstract fun getAccessToken(): String?`<br>Retrieve active access token assigned for active session |
| [getAuthorizationHeader](get-authorization-header.md) | `open fun getAuthorizationHeader(): String`<br>Generates authorization header value by combining token type and token value |
| [getRefreshToken](get-refresh-token.md) | `abstract fun getRefreshToken(): String?`<br>Retrieve active refresh token assign for active session |
| [getTokenType](get-token-type.md) | `abstract fun getTokenType(): String?`<br>Retrieve token type (e.g. Bearer) used for user authorization |
| [getUsername](get-username.md) | `abstract fun getUsername(): String?`<br>Retrieve username of authorized user |
| [login](login.md) | `abstract fun login(username: String, password: String): Unit` |
| [logout](logout.md) | `abstract fun logout(): Unit` |
| [refreshToken](refresh-token.md) | `abstract fun refreshToken(): Unit` |
| [save](save.md) | `abstract fun save(accessToken: String, refreshToken: String, tokenType: String): Unit`<br>Save tokens assign to newly created session |
| [saveUsername](save-username.md) | `abstract fun saveUsername(username: String): Unit`<br>Saves username of authorized user |

### Inheritors

| Name | Summary |
|---|---|
| [OAuth2Repository](../../com.github.kacso.androidcommons.security.repositories.impl/-o-auth2-repository/index.md) | `open class OAuth2Repository : IOAuth2Repository` |
