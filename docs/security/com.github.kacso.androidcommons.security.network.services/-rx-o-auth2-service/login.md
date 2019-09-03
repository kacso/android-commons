[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [RxOAuth2Service](index.md) / [login](.)

# login

`abstract fun login(username: String, password: String, grantType: String = "password", authorizationKey: String): <ERROR CLASS><`[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md)`>`

Perform user login request. If successful, [OAuth2LoginResponse](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) will be returned through
[Single](#). In case of an error appropriate [NetworkException](#) will be thrown.

### Parameters

`username` - username of user trying to login

`password` - password of user trying to login

`grantType` - for this type of login, default is password

`authorizationKey` - key issued by server which authorizes access for this app

**Return**
emits [OAuth2LoginResponse](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) or [NetworkException](#) in case of an error through [Single](#)

