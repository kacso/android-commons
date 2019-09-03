[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [OAuth2Service](.)

# OAuth2Service

`interface OAuth2Service`

Network service which handles user authorization requests

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [login](login.md) | `abstract fun login(username: String, password: String, grantType: String = "password", authorizationKey: String): `[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) |
| [logout](logout.md) | `abstract fun logout(token: String): <ERROR CLASS>` |
| [refreshToken](refresh-token.md) | `abstract fun refreshToken(refreshToken: String, grantType: String = "refresh_token", authorizationKey: String): `[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) |
