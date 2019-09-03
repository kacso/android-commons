[core](../../index.md) / [com.github.kacso.androidcommons.core.views](../index.md) / [BaseView](index.md) / [redirectToLogin](.)

# redirectToLogin

`abstract fun redirectToLogin(forceRedirect: Boolean = false): Unit`

Redirect user to login.
Should be used in case of long inactivity or when token/session has expired

### Parameters

`forceRedirect` - enforce redirect to login without showing message to user.
Useful for logout functionality