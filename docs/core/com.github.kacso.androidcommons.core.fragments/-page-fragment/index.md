[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [PageFragment](./index.md)

# PageFragment

`abstract class PageFragment : `[`BaseFragment`](../-base-fragment/index.md)`, `[`PageView`](../../com.github.kacso.androidcommons.core.views/-page-view/index.md)

Abstract class for fragments which are used in ViewPager.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PageFragment()`<br>Abstract class for fragments which are used in ViewPager. |

### Inherited Properties

| Name | Summary |
|---|---|
| [layoutRes](../-base-fragment/layout-res.md) | `abstract val layoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Reference to layout resource of current fragment. |
| [permissionManager](../-base-fragment/permission-manager.md) | `open val permissionManager: IPermissionManager` |
| [progressDialog](../-base-fragment/progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../../com.github.kacso.androidcommons.core.dialogs/-abstract-progress-dialog/index.md) |
| [rootView](../-base-fragment/root-view.md) | `lateinit var rootView: View`<br>Root view of fragment. Use it to access other views in layout. |
| [viewModel](../-base-fragment/view-model.md) | `abstract val viewModel: `[`IBaseViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md)`?`<br>View model associated with this fragment |

### Inherited Functions

| Name | Summary |
|---|---|
| [backPressed](../-base-fragment/back-pressed.md) | `open fun backPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Should be called when user presses back button |
| [getTitleRes](../../com.github.kacso.androidcommons.core.views/-page-view/get-title-res.md) | `abstract fun getTitleRes(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Function to retrieve title of page |
| [getViewContext](../-base-fragment/get-view-context.md) | `open fun getViewContext(): Context?` |
| [hideProgress](../-base-fragment/hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hide progress of long running task |
| [initViewModelListeners](../-base-fragment/init-view-model-listeners.md) | `open fun initViewModelListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [onCreateView](../-base-fragment/on-create-view.md) | `open fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View` |
| [onError](../-base-fragment/on-error.md) | `open fun onError(error: ErrorHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [error](../-base-fragment/on-error.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$onError(com.github.kacso.androidcommons.data.ErrorHolder)/error) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [onRequestPermissionsResult](../-base-fragment/on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [redirectToLogin](../-base-fragment/redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Redirect user to login. Should be used in case of long inactivity or when token/session has expired |
| [showMessage](../-base-fragment/show-message.md) | `open fun showMessage(msg: MessageHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [msg](../-base-fragment/show-message.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$showMessage(com.github.kacso.androidcommons.data.MessageHolder)/msg) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [showProgress](../-base-fragment/show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Display progress for long running tasks |

### Inheritors

| Name | Summary |
|---|---|
| [PageListFragment](../-page-list-fragment/index.md) | `abstract class PageListFragment<T> : `[`PageFragment`](./index.md)`, `[`PageView`](../../com.github.kacso.androidcommons.core.views/-page-view/index.md)<br>Abstract class for fragments which are used in ViewPager and are displaying list in [RecyclerView](#). |
