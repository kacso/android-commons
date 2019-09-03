[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [BaseFragment](.)

# BaseFragment

`abstract class BaseFragment : `[`BaseView`](../../com.github.kacso.androidcommons.core.views/-base-view/index.md)

Abstract [Fragment](#) class which implements common functionalities from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and solves
most common tasks in Fragment.

It is advisable that all fragments in project extend this class.

In case that you are implementing this class, make sure to implement [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) within your fragment.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseFragment()`<br>Abstract [Fragment](#) class which implements common functionalities from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and solves
most common tasks in Fragment. |

### Properties

| Name | Summary |
|---|---|
| [layoutRes](layout-res.md) | `abstract val layoutRes: Int`<br>Reference to layout resource of current fragment. |
| [permissionManager](permission-manager.md) | `open val permissionManager: <ERROR CLASS>` |
| [progressDialog](progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../../com.github.kacso.androidcommons.core.dialogs/-abstract-progress-dialog/index.md) |
| [rootView](root-view.md) | `lateinit var rootView: <ERROR CLASS>`<br>Root view of fragment. Use it to access other views in layout. |
| [viewModel](view-model.md) | `abstract val viewModel: `[`IBaseViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md)`?`<br>View model associated with this fragment |

### Functions

| Name | Summary |
|---|---|
| [backPressed](back-pressed.md) | `open fun backPressed(): Unit`<br>Should be called when user presses back button |
| [getViewContext](get-view-context.md) | `open fun getViewContext(): <ERROR CLASS>?` |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): Unit`<br>Hide progress of long running task |
| [initViewModelListeners](init-view-model-listeners.md) | `open fun initViewModelListeners(): Unit`<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [onCreateView](on-create-view.md) | `open fun onCreateView(inflater: <ERROR CLASS>, container: <ERROR CLASS>?, savedInstanceState: <ERROR CLASS>?): <ERROR CLASS>` |
| [onError](on-error.md) | `open fun onError(error: <ERROR CLASS>): Unit`<br>By default, it will display [error](on-error.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$onError()/error) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [onRequestPermissionsResult](on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Unit` |
| [redirectToLogin](redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: Boolean): Unit`<br>Redirect user to login.
Should be used in case of long inactivity or when token/session has expired |
| [showMessage](show-message.md) | `open fun showMessage(msg: <ERROR CLASS>): Unit`<br>By default, it will display [msg](show-message.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$showMessage()/msg) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [showProgress](show-progress.md) | `open fun showProgress(): Unit`<br>Display progress for long running tasks |

### Inheritors

| Name | Summary |
|---|---|
| [ListFragment](../-list-fragment/index.md) | `abstract class ListFragment<T> : BaseFragment`<br>This class provides default implementation for fragments with [RecyclerView](#) |
| [PageFragment](../-page-fragment/index.md) | `abstract class PageFragment : BaseFragment, `[`PageView`](../../com.github.kacso.androidcommons.core.views/-page-view/index.md)<br>Abstract class for fragments which are used in ViewPager. |
| [PagerFragment](../-pager-fragment/index.md) | `abstract class PagerFragment : BaseFragment, `[`PagerView`](../../com.github.kacso.androidcommons.core.views/-pager-view/index.md)<br>Abstract class with common functionalities which are used in fragment with [ViewPager](#) |
