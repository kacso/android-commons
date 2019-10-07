[core](../../index.md) / [com.github.kacso.androidcommons.core.views](../index.md) / [BaseView](index.md) / [redirectToLogin](./redirect-to-login.md)

# redirectToLogin

`abstract fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Redirect user to login.
Should be used in case of long inactivity or when token/session has expired

### Parameters

`forceRedirect` - enforce redirect to login without showing message to user.
    Useful for logout functionality