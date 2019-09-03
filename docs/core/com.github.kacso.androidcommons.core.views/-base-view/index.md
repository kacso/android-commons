[core](../../index.md) / [com.github.kacso.androidcommons.core.views](../index.md) / [BaseView](.)

# BaseView

`interface BaseView`

Interface which defines basic functionalities that each view should implement

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [backPressed](back-pressed.md) | `abstract fun backPressed(): Unit`<br>Should be called when user presses back button |
| [getViewContext](get-view-context.md) | `abstract fun getViewContext(): <ERROR CLASS>?` |
| [hideProgress](hide-progress.md) | `abstract fun hideProgress(): Unit`<br>Hide progress of long running task |
| [onError](on-error.md) | `abstract fun onError(error: <ERROR CLASS>): Unit`<br>Display error message to the user |
| [redirectToLogin](redirect-to-login.md) | `abstract fun redirectToLogin(forceRedirect: Boolean = false): Unit`<br>Redirect user to login.
Should be used in case of long inactivity or when token/session has expired |
| [showMessage](show-message.md) | `abstract fun showMessage(msg: <ERROR CLASS>): Unit`<br>Display any message to the user |
| [showProgress](show-progress.md) | `abstract fun showProgress(): Unit`<br>Display progress for long running tasks |

### Inheritors

| Name | Summary |
|---|---|
| [BaseActivity](../../com.github.kacso.androidcommons.core.activities/-base-activity/index.md) | `abstract class BaseActivity : BaseView`<br>Abstract [AppCompatActivity](#) class which implements common functionalities from BaseView and solves
most common tasks in Activity. |
| [BaseDialog](../../com.github.kacso.androidcommons.core.dialogs/-base-dialog/index.md) | `abstract class BaseDialog : BaseView`<br>Abstract [DialogFragment](#) class which implements common functions from BaseView and also solves most
common tasks in Dialog. |
| [BaseFragment](../../com.github.kacso.androidcommons.core.fragments/-base-fragment/index.md) | `abstract class BaseFragment : BaseView`<br>Abstract [Fragment](#) class which implements common functionalities from BaseView and solves
most common tasks in Fragment. |
