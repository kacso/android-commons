[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [DialogMessage](./index.md)

# DialogMessage

`class DialogMessage : `[`BaseDialog`](../-base-dialog/index.md)

Dialog for displaying actionable messages to user

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DialogMessage()`<br>Dialog for displaying actionable messages to user |

### Inherited Properties

| Name | Summary |
|---|---|
| [permissionManager](../-base-dialog/permission-manager.md) | `open val permissionManager: IPermissionManager` |
| [progressDialog](../-base-dialog/progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../-abstract-progress-dialog/index.md) |
| [rootView](../-base-dialog/root-view.md) | `lateinit var rootView: View`<br>Root view of the dialog. Use it to access other views inside layout |
| [viewModel](../-base-dialog/view-model.md) | `open val viewModel: `[`IBaseViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md)`?`<br>View model associated with this dialog |

### Functions

| Name | Summary |
|---|---|
| [dismissAllowingStateLoss](dismiss-allowing-state-loss.md) | `fun dismissAllowingStateLoss(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getLayout](get-layout.md) | `fun getLayout(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method is being used in order to inflate view for dialog |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View` |
| [onDismiss](on-dismiss.md) | `fun onDismiss(dialog: DialogInterface): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [applyStyle](../-base-dialog/apply-style.md) | `open fun applyStyle(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method is called in order to set user defined theme to dialog Override it in case that you don't want to set any theme, or would like to set theme different then defined in [BaseApplication.getDialogTheme](../../com.github.kacso.androidcommons.core/-base-application/get-dialog-theme.md) |
| [backPressed](../-base-dialog/back-pressed.md) | `open fun backPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Should be called when user presses back button |
| [getViewContext](../-base-dialog/get-view-context.md) | `open fun getViewContext(): Context?` |
| [hideProgress](../-base-dialog/hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hide progress of long running task |
| [initViewModelListeners](../-base-dialog/init-view-model-listeners.md) | `open fun initViewModelListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [onCreate](../-base-dialog/on-create.md) | `open fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](../-base-dialog/on-error.md) | `open fun onError(error: ErrorHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [error](../-base-dialog/on-error.md#com.github.kacso.androidcommons.core.dialogs.BaseDialog$onError(com.github.kacso.androidcommons.data.ErrorHolder)/error) in [Toast](#) with duration set to [Toast.LENGTH_LONG](#) |
| [onRequestPermissionsResult](../-base-dialog/on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [redirectToLogin](../-base-dialog/redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Redirect user to login. Should be used in case of long inactivity or when token/session has expired |
| [showMessage](../-base-dialog/show-message.md) | `open fun showMessage(msg: MessageHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [msg](../-base-dialog/show-message.md#com.github.kacso.androidcommons.core.dialogs.BaseDialog$showMessage(com.github.kacso.androidcommons.data.MessageHolder)/msg) in [Toast](#) with duration set to [Toast.LENGTH_LONG](#) |
| [showProgress](../-base-dialog/show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display progress for long running tasks |

### Companion Object Functions

| Name | Summary |
|---|---|
| [newInstance](new-instance.md) | `fun newInstance(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, positiveLbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, dismissLbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, dismissible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, positiveAction: `[`Action`](../../com.github.kacso.androidcommons.core/-action.md)`? = null, dismissAction: `[`Action`](../../com.github.kacso.androidcommons.core/-action.md)`? = null): `[`DialogMessage`](./index.md)<br>Creates new instance of DialogMessage. Dialog is automatically dismissed when user taps on any of available buttons. |
