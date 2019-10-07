[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [BaseFragment](./index.md)

# BaseFragment

`abstract class BaseFragment : Fragment, `[`BaseView`](../../com.github.kacso.androidcommons.core.views/-base-view/index.md)

Abstract [Fragment](#) class which implements common functionalities from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and solves
most common tasks in Fragment.

It is advisable that all fragments in project extend this class.

In case that you are implementing this class, make sure to implement [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) within your fragment.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseFragment()`<br>Abstract [Fragment](#) class which implements common functionalities from [BaseView](../../com.github.kacso.androidcommons.core.views/-base-view/index.md) and solves most common tasks in Fragment. |

### Properties

| Name | Summary |
|---|---|
| [layoutRes](layout-res.md) | `abstract val layoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Reference to layout resource of current fragment. |
| [permissionManager](permission-manager.md) | `open val permissionManager: IPermissionManager` |
| [progressDialog](progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../../com.github.kacso.androidcommons.core.dialogs/-abstract-progress-dialog/index.md) |
| [rootView](root-view.md) | `lateinit var rootView: View`<br>Root view of fragment. Use it to access other views in layout. |
| [viewModel](view-model.md) | `abstract val viewModel: `[`IBaseViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md)`?`<br>View model associated with this fragment |

### Functions

| Name | Summary |
|---|---|
| [backPressed](back-pressed.md) | `open fun backPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Should be called when user presses back button |
| [getViewContext](get-view-context.md) | `open fun getViewContext(): Context?` |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hide progress of long running task |
| [initViewModelListeners](init-view-model-listeners.md) | `open fun initViewModelListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [onCreateView](on-create-view.md) | `open fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View` |
| [onError](on-error.md) | `open fun onError(error: ErrorHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [error](on-error.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$onError(com.github.kacso.androidcommons.data.ErrorHolder)/error) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [onRequestPermissionsResult](on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [redirectToLogin](redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Redirect user to login. Should be used in case of long inactivity or when token/session has expired |
| [showMessage](show-message.md) | `open fun showMessage(msg: MessageHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [msg](show-message.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$showMessage(com.github.kacso.androidcommons.data.MessageHolder)/msg) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [showProgress](show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display progress for long running tasks |

### Inheritors

| Name | Summary |
|---|---|
| [ListFragment](../-list-fragment/index.md) | `abstract class ListFragment<T> : `[`BaseFragment`](./index.md)<br>This class provides default implementation for fragments with [RecyclerView](#) |
| [PageFragment](../-page-fragment/index.md) | `abstract class PageFragment : `[`BaseFragment`](./index.md)`, `[`PageView`](../../com.github.kacso.androidcommons.core.views/-page-view/index.md)<br>Abstract class for fragments which are used in ViewPager. |
| [PagerFragment](../-pager-fragment/index.md) | `abstract class PagerFragment : `[`BaseFragment`](./index.md)`, `[`PagerView`](../../com.github.kacso.androidcommons.core.views/-pager-view/index.md)<br>Abstract class with common functionalities which are used in fragment with [ViewPager](#) |
