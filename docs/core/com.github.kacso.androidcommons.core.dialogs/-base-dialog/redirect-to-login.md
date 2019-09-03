[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [BaseDialog](index.md) / [redirectToLogin](.)

# redirectToLogin

`open fun redirectToLogin(forceRedirect: Boolean): Unit`

Overrides [BaseView.redirectToLogin](../../com.github.kacso.androidcommons.core.views/-base-view/redirect-to-login.md)

Redirect user to login.
Should be used in case of long inactivity or when token/session has expired

### Parameters

`forceRedirect` - enforce redirect to login without showing message to user.
Useful for logout functionality