[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [BaseDialog](./index.md)

# BaseDialog

`abstract class BaseDialog : DialogFragment, `[`BaseView`](../../com.github.kacso.androidcommons.core.views/-base-view/index.md)

Abstract [DialogFragment](#) class which implements common functions from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and also solves most
common tasks in Dialog.

It is advisable that all dialogs in project extend this class.

In case that you are implementing this class, make sure to implement [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) within your dialog.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseDialog()`<br>Abstract [DialogFragment](#) class which implements common functions from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and also solves most common tasks in Dialog. |

### Properties

| Name | Summary |
|---|---|
| [permissionManager](permission-manager.md) | `open val permissionManager: IPermissionManager` |
| [progressDialog](progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../-abstract-progress-dialog/index.md) |
| [rootView](root-view.md) | `lateinit var rootView: View`<br>Root view of the dialog. Use it to access other views inside layout |
| [viewModel](view-model.md) | `open val viewModel: `[`IBaseViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md)`?`<br>View model associated with this dialog |

### Functions

| Name | Summary |
|---|---|
| [applyStyle](apply-style.md) | `open fun applyStyle(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method is called in order to set user defined theme to dialog Override it in case that you don't want to set any theme, or would like to set theme different then defined in [BaseApplication.getDialogTheme](../../com.github.kacso.androidcommons.core/-base-application/get-dialog-theme.md) |
| [backPressed](back-pressed.md) | `open fun backPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Should be called when user presses back button |
| [getLayout](get-layout.md) | `abstract fun getLayout(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method is being used in order to inflate view for dialog |
| [getViewContext](get-view-context.md) | `open fun getViewContext(): Context?` |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hide progress of long running task |
| [initViewModelListeners](init-view-model-listeners.md) | `open fun initViewModelListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [onCreate](on-create.md) | `open fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `open fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?` |
| [onError](on-error.md) | `open fun onError(error: ErrorHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [error](on-error.md#com.github.kacso.androidcommons.core.dialogs.BaseDialog$onError(com.github.kacso.androidcommons.data.ErrorHolder)/error) in [Toast](#) with duration set to [Toast.LENGTH_LONG](#) |
| [onRequestPermissionsResult](on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [redirectToLogin](redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Redirect user to login. Should be used in case of long inactivity or when token/session has expired |
| [showMessage](show-message.md) | `open fun showMessage(msg: MessageHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [msg](show-message.md#com.github.kacso.androidcommons.core.dialogs.BaseDialog$showMessage(com.github.kacso.androidcommons.data.MessageHolder)/msg) in [Toast](#) with duration set to [Toast.LENGTH_LONG](#) |
| [showProgress](show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display progress for long running tasks |

### Inheritors

| Name | Summary |
|---|---|
| [DialogMessage](../-dialog-message/index.md) | `class DialogMessage : `[`BaseDialog`](./index.md)<br>Dialog for displaying actionable messages to user |
