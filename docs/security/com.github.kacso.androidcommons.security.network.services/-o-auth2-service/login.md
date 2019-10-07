[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [OAuth2Service](index.md) / [login](./login.md)

# login

`@FormUrlEncoded @POST("token") abstract suspend fun login(@Field("username") username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Field("password") password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Field("grant_type") grantType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "password", @Header("Authorization") authorizationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`OAuth2LoginResponse`](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md)

Perform user login request. If successful, [OAuth2LoginResponse](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) will be returned through
[Single](#). In case of an error appropriate [NetworkException](#) will be thrown.

### Parameters

`username` - username of user trying to login

`password` - password of user trying to login

`grantType` - for this type of login, default is password

`authorizationKey` - key issued by server which authorizes access for this app

**Return**
[OAuth2LoginResponse](../../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) or throws [NetworkException](#) in case of an error

