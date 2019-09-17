[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [FilterableListFragment](.)

# FilterableListFragment

`abstract class FilterableListFragment<T> : `[`ListFragment`](../-list-fragment/index.md)`<T>`

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
| [layoutRes](layout-res.md) | `open val layoutRes: Int`<br>Reference to layout resource of current fragment. |
| [viewModel](view-model.md) | `abstract val viewModel: `[`FilterableListViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-filterable-list-view-model/index.md)`<T, String>`<br>View model associated with this fragment |

### Inherited Properties

| Name | Summary |
|---|---|
| [adapterDataObserver](../-list-fragment/adapter-data-observer.md) | `open val adapterDataObserver: Any`<br>Observer which will display empty list view returned by [getEmptyListView](../-list-fragment/get-empty-list-view.md) to the user
when there is no data in [RecyclerView](#). |

### Functions

| Name | Summary |
|---|---|
| [getEmptyListView](get-empty-list-view.md) | `open fun getEmptyListView(): <ERROR CLASS>?`<br>Return view that will be displayed to user when there is no data in [RecyclerView](#).
By default it will return [TextView](#) with default message. To change message displayed
call [setEmptyListViewText](../-list-fragment/set-empty-list-view-text.md). |
| [getListView](get-list-view.md) | `open fun getListView(): <ERROR CLASS>`<br>Returns RecyclerView which will display data.
Override this function in case when you are using custom layout |
| [getSwipeRefreshView](get-swipe-refresh-view.md) | `open fun getSwipeRefreshView(): <ERROR CLASS>?`<br>Returns SwipeRefreshLayout which will refresh data.
Override this function in case when you are using custom layout. |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): Unit`<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |
| [onViewCreated](on-view-created.md) | `open fun onViewCreated(view: <ERROR CLASS>, savedInstanceState: <ERROR CLASS>?): Unit` |
| [setSearchListener](set-search-listener.md) | `open fun setSearchListener(): Unit`<br>Initialize [SearchView](#) listener in order to update search term in view model. |
| [showProgress](show-progress.md) | `open fun showProgress(): Unit`<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |

### Inherited Functions

| Name | Summary |
|---|---|
| [getAdapter](../-list-fragment/get-adapter.md) | `abstract fun getAdapter(): <ERROR CLASS><out <ERROR CLASS>>`<br>Function for retrieving adapter for RecyclerView.
Make sure to return always same instance of adapter! |
| [setEmptyListViewText](../-list-fragment/set-empty-list-view-text.md) | `open fun setEmptyListViewText(msg: String): Unit`<br>Set [msg](../-list-fragment/set-empty-list-view-text.md#com.github.kacso.androidcommons.core.fragments.ListFragment$setEmptyListViewText(kotlin.String)/msg) as text that should be displayed to user when there is no data in [RecyclerView](#).
This function will work with any [View](#) returned from [getEmptyListView](../-list-fragment/get-empty-list-view.md) which extends [TextView](#). |
