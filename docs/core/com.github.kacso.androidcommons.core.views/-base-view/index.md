[core](../../index.md) / [com.github.kacso.androidcommons.core.views](../index.md) / [BaseView](./index.md)

# BaseView

`interface BaseView`

Interface which defines basic functionalities that each view should implement

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [backPressed](back-pressed.md) | `abstract fun backPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Should be called when user presses back button |
| [getViewContext](get-view-context.md) | `abstract fun getViewContext(): Context?` |
| [hideProgress](hide-progress.md) | `abstract fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hide progress of long running task |
| [onError](on-error.md) | `abstract fun onError(error: ErrorHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display error message to the user |
| [redirectToLogin](redirect-to-login.md) | `abstract fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Redirect user to login. Should be used in case of long inactivity or when token/session has expired |
| [showMessage](show-message.md) | `abstract fun showMessage(msg: MessageHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display any message to the user |
| [showProgress](show-progress.md) | `abstract fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display progress for long running tasks |

### Inheritors

| Name | Summary |
|---|---|
| [BaseActivity](../../com.github.kacso.androidcommons.core.activities/-base-activity/index.md) | `abstract class BaseActivity : AppCompatActivity, `[`BaseView`](./index.md)<br>Abstract [AppCompatActivity](#) class which implements common functionalities from [BaseView](./index.md) and solves most common tasks in Activity. |
| [BaseDialog](../../com.github.kacso.androidcommons.core.dialogs/-base-dialog/index.md) | `abstract class BaseDialog : DialogFragment, `[`BaseView`](./index.md)<br>Abstract [DialogFragment](#) class which implements common functions from [BaseView](./index.md) and also solves most common tasks in Dialog. |
| [BaseFragment](../../com.github.kacso.androidcommons.core.fragments/-base-fragment/index.md) | `abstract class BaseFragment : Fragment, `[`BaseView`](./index.md)<br>Abstract [Fragment](#) class which implements common functionalities from [BaseView](./index.md) and solves most common tasks in Fragment. |
