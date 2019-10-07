[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [ListFragment](./index.md)

# ListFragment

`abstract class ListFragment<T> : `[`BaseFragment`](../-base-fragment/index.md)

This class provides default implementation for fragments with [RecyclerView](#)

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ListFragment()`<br>This class provides default implementation for fragments with [RecyclerView](#) |

### Properties

| Name | Summary |
|---|---|
| [adapterDataObserver](adapter-data-observer.md) | `open val adapterDataObserver: AdapterDataObserver`<br>Observer which will display empty list view returned by [getEmptyListView](get-empty-list-view.md) to the user when there is no data in [RecyclerView](#). |
| [layoutRes](layout-res.md) | `open val layoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Reference to layout resource of current fragment. |
| [viewModel](view-model.md) | `abstract val viewModel: `[`ListViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-list-view-model/index.md)`<`[`T`](index.md#T)`>`<br>View model associated with this fragment |

### Inherited Properties

| Name | Summary |
|---|---|
| [permissionManager](../-base-fragment/permission-manager.md) | `open val permissionManager: IPermissionManager` |
| [progressDialog](../-base-fragment/progress-dialog.md) | `open val progressDialog: `[`AbstractProgressDialog`](../../com.github.kacso.androidcommons.core.dialogs/-abstract-progress-dialog/index.md) |
| [rootView](../-base-fragment/root-view.md) | `lateinit var rootView: View`<br>Root view of fragment. Use it to access other views in layout. |

### Functions

| Name | Summary |
|---|---|
| [getAdapter](get-adapter.md) | `abstract fun getAdapter(): Adapter<*>`<br>Function for retrieving adapter for RecyclerView. Make sure to return always same instance of adapter! |
| [getEmptyListView](get-empty-list-view.md) | `open fun getEmptyListView(): View?`<br>Return view that will be displayed to user when there is no data in [RecyclerView](#). By default it will return [TextView](#) with default message. To change message displayed call [setEmptyListViewText](set-empty-list-view-text.md). |
| [getListView](get-list-view.md) | `open fun getListView(): RecyclerView`<br>Returns RecyclerView which will display data. Override this function in case when you are using custom layout |
| [getSwipeRefreshView](get-swipe-refresh-view.md) | `open fun getSwipeRefreshView(): SwipeRefreshLayout?`<br>Returns SwipeRefreshLayout which will refresh data. Override this function in case when you are using custom layout. |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |
| [onViewCreated](on-view-created.md) | `open fun onViewCreated(view: View, savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setEmptyListViewText](set-empty-list-view-text.md) | `open fun setEmptyListViewText(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set [msg](set-empty-list-view-text.md#com.github.kacso.androidcommons.core.fragments.ListFragment$setEmptyListViewText(kotlin.String)/msg) as text that should be displayed to user when there is no data in [RecyclerView](#). This function will work with any [View](#) returned from [getEmptyListView](get-empty-list-view.md) which extends [TextView](#). |
| [showProgress](show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |

### Inherited Functions

| Name | Summary |
|---|---|
| [backPressed](../-base-fragment/back-pressed.md) | `open fun backPressed(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Should be called when user presses back button |
| [getViewContext](../-base-fragment/get-view-context.md) | `open fun getViewContext(): Context?` |
| [initViewModelListeners](../-base-fragment/init-view-model-listeners.md) | `open fun initViewModelListeners(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Function which will start observing [LiveData](#) objects from [IBaseViewModel](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-i-base-view-model/index.md) |
| [onCreateView](../-base-fragment/on-create-view.md) | `open fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View` |
| [onError](../-base-fragment/on-error.md) | `open fun onError(error: ErrorHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [error](../-base-fragment/on-error.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$onError(com.github.kacso.androidcommons.data.ErrorHolder)/error) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |
| [onRequestPermissionsResult](../-base-fragment/on-request-permissions-result.md) | `open fun onRequestPermissionsResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [redirectToLogin](../-base-fragment/redirect-to-login.md) | `open fun redirectToLogin(forceRedirect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Redirect user to login. Should be used in case of long inactivity or when token/session has expired |
| [showMessage](../-base-fragment/show-message.md) | `open fun showMessage(msg: MessageHolder): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>By default, it will display [msg](../-base-fragment/show-message.md#com.github.kacso.androidcommons.core.fragments.BaseFragment$showMessage(com.github.kacso.androidcommons.data.MessageHolder)/msg) in [Snackbar](#) with duration set to [Snackbar.LENGTH_LONG](#) |

### Inheritors

| Name | Summary |
|---|---|
| [FilterableListFragment](../-filterable-list-fragment/index.md) | `abstract class FilterableListFragment<T> : `[`ListFragment`](./index.md)`<`[`T`](../-filterable-list-fragment/index.md#T)`>`<br>This class provides default implementation for fragments with [RecyclerView](#) and search field |
