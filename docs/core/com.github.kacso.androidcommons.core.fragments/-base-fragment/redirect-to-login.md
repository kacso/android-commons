[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [BaseFragment](index.md) / [redirectToLogin](./redirect-to-login.md)

# redirectToLogin

`open fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [BaseView.redirectToLogin](../../com.github.kacso.androidcommons.core.views/-base-view/redirect-to-login.md)

Redirect user to login.
Should be used in case of long inactivity or when token/session has expired

### Parameters

`forceRedirect` - enforce redirect to login without showing message to user.
    Useful for logout functionality