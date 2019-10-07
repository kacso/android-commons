[core](../../index.md) / [com.github.kacso.androidcommons.core.activities](../index.md) / [BaseActivity](./index.md)

# BaseActivity

`abstract class BaseActivity : AppCompatActivity, `[`BaseView`](../../com.github.kacso.androidcommons.core.views/-base-view/index.md)

Abstract [AppCompatActivity](#) class which implements common functionalities from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and solves
most common tasks in Activity.

It is advisable that all activities in project extend this class.

In case that you are implementing this class, make sure to implement [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) within your activity.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseActivity()`<br>Abstract [AppCompatActivity](#) class which implements common functionalities from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and solves most common tasks in Activity. |

### Properties

| Name | Summary |
|---|---|
| [layoutRes](layout-res.md) | `abstract val layoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Reference to layout resource of current activity. |
| [permissionManager](permission-manager.md) | `open val permissionManager: IPermissionManager` |
| [progressDialog](progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../../com.github.kacso.androidcommons.core.dialogs/-abstract-progress-dialog/index.md) |
| [viewModel](view-model.md) | `abstract val viewModel: `[`IBaseViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md)`?`<br>View model associated with this activity |

### Functions

| Name | Summary |
|---|---|
| [attachBaseContext](attach-base-context.md) | `open fun attachBaseContext(newBase: Context): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [backPressed](back-pressed.md) | `open fun backPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default it will call extension function [goBack](#) |
| [getAlternativeThemeRes](get-alternative-theme-res.md) | `open fun getAlternativeThemeRes(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?`<br>This method is called in order to assign user defined themes to activity. By default, this method will return theme defined in [BaseApplication.getAppTheme](../../com.github.kacso.androidcommons.core/-base-application/get-app-theme.md). |
| [getContentHolder](get-content-holder.md) | `abstract fun getContentHolder(): View`<br>Gets root view of current activity. This view is being used to display default messages and progress. |
| [getUserLocale](get-user-locale.md) | `open fun getUserLocale(context: Context): `[`Locale`](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)<br>Returns locale defined by user in settings, if such option does not exist, return device default locale. |
| [getViewContext](get-view-context.md) | `open fun getViewContext(): Context?` |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hide progress of long running task |
| [initViewModelListeners](init-view-model-listeners.md) | `open fun initViewModelListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [isActive](is-active.md) | `open fun isActive(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onBackPressed](on-back-pressed.md) | `open fun onBackPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, call [backPressed](back-pressed.md) |
| [onCreate](on-create.md) | `open fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](on-error.md) | `open fun onError(error: ErrorHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [error](on-error.md#com.github.kacso.androidcommons.core.activities.BaseActivity$onError(com.github.kacso.androidcommons.data.ErrorHolder)/error) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [onRequestPermissionsResult](on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onResume](on-resume.md) | `open fun onResume(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSupportNavigateUp](on-support-navigate-up.md) | `open fun onSupportNavigateUp(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>By default, call [backPressed](back-pressed.md) |
| [redirectToLogin](redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Redirect user to login. Should be used in case of long inactivity or when token/session has expired |
| [showMessage](show-message.md) | `open fun showMessage(msg: MessageHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [msg](show-message.md#com.github.kacso.androidcommons.core.activities.BaseActivity$showMessage(com.github.kacso.androidcommons.data.MessageHolder)/msg) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [showProgress](show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display progress for long running tasks |

### Companion Object Properties

| Name | Summary |
|---|---|
| [currentView](current-view.md) | `var currentView: `[`BaseActivity`](./index.md)`?`<br>Instance of currently visible [BaseActivity](./index.md) |
