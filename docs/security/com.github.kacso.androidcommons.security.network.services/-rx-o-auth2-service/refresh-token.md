[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [RxOAuth2Service](index.md) / [refreshToken](.)

# refreshToken

`abstract fun refreshToken(refreshToken: String, grantType: String = "refresh_token", authorizationKey: String): <ERROR CLASS><`[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md)`>`

Performs access token refresh. If successful, it will return new tokens, otherwise
[NetworkException](#) will be thrown.

### Parameters

`refreshToken` - refresh token return by server during access token retrieval

`grantType` - for this type of request, default is refresh_token

`authorizationKey` - key issued by server which authorizes access for this app

**Return**
emits [OAuth2LoginResponse](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) or [NetworkException](#) in case of an error through [Single](#)

