[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [DialogMessage](.)

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
| [permissionManager](../-base-dialog/permission-manager.md) | `open val permissionManager: <ERROR CLASS>` |
| [progressDialog](../-base-dialog/progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../-abstract-progress-dialog/index.md) |
| [rootView](../-base-dialog/root-view.md) | `lateinit var rootView: <ERROR CLASS>`<br>Root view of the dialog. Use it to access other views inside layout |
| [viewModel](../-base-dialog/view-model.md) | `open val viewModel: `[`IBaseViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md)`?`<br>View model associated with this dialog |

### Functions

| Name | Summary |
|---|---|
| [dismissAllowingStateLoss](dismiss-allowing-state-loss.md) | `fun dismissAllowingStateLoss(): Unit` |
| [getLayout](get-layout.md) | `fun getLayout(): Int`<br>This method is being used in order to inflate view for dialog |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: <ERROR CLASS>, container: <ERROR CLASS>?, savedInstanceState: <ERROR CLASS>?): <ERROR CLASS>` |
| [onDismiss](on-dismiss.md) | `fun onDismiss(dialog: <ERROR CLASS>): Unit` |

### Inherited Functions

| Name | Summary |
|---|---|
| [applyStyle](../-base-dialog/apply-style.md) | `open fun applyStyle(): Unit`<br>This method is called in order to set user defined theme to dialog
Override it in case that you dont want to set any theme, or would like to set
theme different then defined in [BaseApplication.getDialogTheme](../../com.github.kacso.androidcommons.core/-base-application/get-dialog-theme.md) |
| [backPressed](../-base-dialog/back-pressed.md) | `open fun backPressed(): Unit`<br>Should be called when user presses back button |
| [getViewContext](../-base-dialog/get-view-context.md) | `open fun getViewContext(): <ERROR CLASS>?` |
| [hideProgress](../-base-dialog/hide-progress.md) | `open fun hideProgress(): Unit`<br>Hide progress of long running task |
| [initViewModelListeners](../-base-dialog/init-view-model-listeners.md) | `open fun initViewModelListeners(): Unit`<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [onCreate](../-base-dialog/on-create.md) | `open fun onCreate(savedInstanceState: <ERROR CLASS>?): Unit` |
| [onError](../-base-dialog/on-error.md) | `open fun onError(error: <ERROR CLASS>): Unit`<br>By default, it will display [error](../-base-dialog/on-error.md#com.github.kacso.androidcommons.core.dialogs.BaseDialog$onError()/error) in [Toast](#) with duration set to [Toast.LENGTH_LONG](#) |
| [onRequestPermissionsResult](../-base-dialog/on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Unit` |
| [redirectToLogin](../-base-dialog/redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: Boolean): Unit`<br>Redirect user to login.
Should be used in case of long inactivity or when token/session has expired |
| [showMessage](../-base-dialog/show-message.md) | `open fun showMessage(msg: <ERROR CLASS>): Unit`<br>By default, it will display [msg](../-base-dialog/show-message.md#com.github.kacso.androidcommons.core.dialogs.BaseDialog$showMessage()/msg) in [Toast](#) with duration set to [Toast.LENGTH_LONG](#) |
| [showProgress](../-base-dialog/show-progress.md) | `open fun showProgress(): Unit`<br>Display progress for long running tasks |

### Companion Object Functions

| Name | Summary |
|---|---|
| [newInstance](new-instance.md) | `fun newInstance(title: String? = null, message: String, positiveLbl: String? = null, dismissLbl: String? = null, dismissible: Boolean = true, positiveAction: <ERROR CLASS>? = null, dismissAction: <ERROR CLASS>? = null): DialogMessage`<br>Creates new instance of DialogMessage. Dialog is automatically dismissed when user
taps on any of available buttons. |
