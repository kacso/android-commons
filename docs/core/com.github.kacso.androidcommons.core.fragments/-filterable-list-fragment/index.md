[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [FilterableListFragment](./index.md)

# FilterableListFragment

`abstract class FilterableListFragment<T> : `[`ListFragment`](../-list-fragment/index.md)`<`[`T`](index.md#T)`>`

This class provides default implementation for fragments with [RecyclerView](#) and search field

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FilterableListFragment()`<br>This class provides default implementation for fragments with [RecyclerView](#) and search field |

### Properties

| Name | Summary |
|---|---|
| [layoutRes](layout-res.md) | `open val layoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Reference to layout resource of current fragment. |
| [viewModel](view-model.md) | `abstract val viewModel: `[`FilterableListViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-filterable-list-view-model/index.md)`<`[`T`](index.md#T)`, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>View model associated with this fragment |

### Inherited Properties

| Name | Summary |
|---|---|
| [adapterDataObserver](../-list-fragment/adapter-data-observer.md) | `open val adapterDataObserver: AdapterDataObserver`<br>Observer which will display empty list view returned by [getEmptyListView](../-list-fragment/get-empty-list-view.md) to the user when there is no data in [RecyclerView](#). |

### Functions

| Name | Summary |
|---|---|
| [getEmptyListView](get-empty-list-view.md) | `open fun getEmptyListView(): View?`<br>Return view that will be displayed to user when there is no data in [RecyclerView](#). By default it will return [TextView](#) with default message. To change message displayed call [setEmptyListViewText](../-list-fragment/set-empty-list-view-text.md). |
| [getListView](get-list-view.md) | `open fun getListView(): RecyclerView`<br>Returns RecyclerView which will display data. Override this function in case when you are using custom layout |
| [getSwipeRefreshView](get-swipe-refresh-view.md) | `open fun getSwipeRefreshView(): SwipeRefreshLayout?`<br>Returns SwipeRefreshLayout which will refresh data. Override this function in case when you are using custom layout. |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |
| [onViewCreated](on-view-created.md) | `open fun onViewCreated(view: View, savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setSearchListener](set-search-listener.md) | `open fun setSearchListener(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Initialize [SearchView](#) listener in order to update search term in view model. |
| [showProgress](show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |

### Inherited Functions

| Name | Summary |
|---|---|
| [getAdapter](../-list-fragment/get-adapter.md) | `abstract fun getAdapter(): Adapter<*>`<br>Function for retrieving adapter for RecyclerView. Make sure to return always same instance of adapter! |
| [setEmptyListViewText](../-list-fragment/set-empty-list-view-text.md) | `open fun setEmptyListViewText(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set [msg](../-list-fragment/set-empty-list-view-text.md#com.github.kacso.androidcommons.core.fragments.ListFragment$setEmptyListViewText(kotlin.String)/msg) as text that should be displayed to user when there is no data in [RecyclerView](#). This function will work with any [View](#) returned from [getEmptyListView](../-list-fragment/get-empty-list-view.md) which extends [TextView](#). |
