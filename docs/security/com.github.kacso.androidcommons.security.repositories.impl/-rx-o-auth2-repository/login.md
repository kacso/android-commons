[security](../../index.md) / [com.github.kacso.androidcommons.security.repositories.impl](../index.md) / [RxOAuth2Repository](index.md) / [login](./login.md)

# login

`open fun login(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Completable`

Overrides [IRxOAuth2Repository.login](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/login.md)

Authorize user according to provided credentials

### Parameters

`username` - username of user trying to login

`password` - password of user trying to login

**Return**
[Completable](#) which will indicate if login was successful or not

