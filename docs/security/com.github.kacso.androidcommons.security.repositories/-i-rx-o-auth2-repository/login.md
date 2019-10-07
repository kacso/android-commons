[security](../../index.md) / [com.github.kacso.androidcommons.security.repositories](../index.md) / [IRxOAuth2Repository](index.md) / [login](./login.md)

# login

`abstract fun login(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Completable`

Authorize user according to provided credentials

### Parameters

`username` - username of user trying to login

`password` - password of user trying to login

**Return**
[Completable](#) which will indicate if login was successful or not

