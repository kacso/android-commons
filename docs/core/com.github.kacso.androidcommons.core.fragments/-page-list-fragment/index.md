[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [PageListFragment](.)

# PageListFragment

`abstract class PageListFragment<T> : `[`PageFragment`](../-page-fragment/index.md)`, `[`PageView`](../../com.github.kacso.androidcommons.core.views/-page-view/index.md)

Abstract class for fragments which are used in ViewPager and are displaying list in [RecyclerView](#).

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PageListFragment()`<br>Abstract class for fragments which are used in ViewPager and are displaying list in [RecyclerView](#). |

### Properties

| Name | Summary |
|---|---|
| [adapterDataObserver](adapter-data-observer.md) | `open val adapterDataObserver: Any`<br>Observer which will display empty list view returned by [getEmptyListView](get-empty-list-view.md) to the user
when there is no data in [RecyclerView](#). |
| [layoutRes](layout-res.md) | `open val layoutRes: Int`<br>Reference to layout resource of current fragment. |
| [viewModel](view-model.md) | `abstract val viewModel: `[`ListViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-list-view-model/index.md)`<T>`<br>View model associated with this fragment |

### Functions

| Name | Summary |
|---|---|
| [getAdapter](get-adapter.md) | `abstract fun getAdapter(): <ERROR CLASS><out <ERROR CLASS>>`<br>Function for retrieving adapter for RecyclerView.
Make sure to return always same instance of adapter! |
| [getEmptyListView](get-empty-list-view.md) | `open fun getEmptyListView(): <ERROR CLASS>?`<br>Return view that will be displayed to user when there is no data in [RecyclerView](#).
By default it will return [TextView](#) with default message. To change message displayed
call [setEmptyListViewText](set-empty-list-view-text.md). |
| [getListView](get-list-view.md) | `open fun getListView(): <ERROR CLASS>`<br>Returns RecyclerView which will display data.
Override this function in case when you are using custom layout |
| [getSwipeRefreshView](get-swipe-refresh-view.md) | `open fun getSwipeRefreshView(): <ERROR CLASS>?`<br>Returns SwipeRefreshLayout which will refresh data.
Override this function in case when you are using custom layout. |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): Unit`<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |
| [onViewCreated](on-view-created.md) | `open fun onViewCreated(view: <ERROR CLASS>, savedInstanceState: <ERROR CLASS>?): Unit` |
| [setEmptyListViewText](set-empty-list-view-text.md) | `open fun setEmptyListViewText(msg: String): Unit`<br>Set [msg](set-empty-list-view-text.md#com.github.kacso.androidcommons.core.fragments.PageListFragment$setEmptyListViewText(kotlin.String)/msg) as text that should be displayed to user when there is no data in [RecyclerView](#).
This function will work with any [View](#) returned from [getEmptyListView](get-empty-list-view.md) which extends [TextView](#). |
| [showProgress](show-progress.md) | `open fun showProgress(): Unit`<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |
