[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [PageListFragment](./index.md)

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
| [adapterDataObserver](adapter-data-observer.md) | `open val adapterDataObserver: AdapterDataObserver`<br>Observer which will display empty list view returned by [getEmptyListView](get-empty-list-view.md) to the user when there is no data in [RecyclerView](#). |
| [layoutRes](layout-res.md) | `open val layoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Reference to layout resource of current fragment. |
| [viewModel](view-model.md) | `abstract val viewModel: `[`ListViewModel`](../../com.github.kacso.androidcommons.core.mvvm.viewmodels/-list-view-model/index.md)`<`[`T`](index.md#T)`>`<br>View model associated with this fragment |

### Functions

| Name | Summary |
|---|---|
| [getAdapter](get-adapter.md) | `abstract fun getAdapter(): Adapter<*>`<br>Function for retrieving adapter for RecyclerView. Make sure to return always same instance of adapter! |
| [getEmptyListView](get-empty-list-view.md) | `open fun getEmptyListView(): View?`<br>Return view that will be displayed to user when there is no data in [RecyclerView](#). By default it will return [TextView](#) with default message. To change message displayed call [setEmptyListViewText](set-empty-list-view-text.md). |
| [getListView](get-list-view.md) | `open fun getListView(): RecyclerView`<br>Returns RecyclerView which will display data. Override this function in case when you are using custom layout |
| [getSwipeRefreshView](get-swipe-refresh-view.md) | `open fun getSwipeRefreshView(): SwipeRefreshLayout?`<br>Returns SwipeRefreshLayout which will refresh data. Override this function in case when you are using custom layout. |
| [hideProgress](hide-progress.md) | `open fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |
| [onViewCreated](on-view-created.md) | `open fun onViewCreated(view: View, savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setEmptyListViewText](set-empty-list-view-text.md) | `open fun setEmptyListViewText(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set [msg](set-empty-list-view-text.md#com.github.kacso.androidcommons.core.fragments.PageListFragment$setEmptyListViewText(kotlin.String)/msg) as text that should be displayed to user when there is no data in [RecyclerView](#). This function will work with any [View](#) returned from [getEmptyListView](get-empty-list-view.md) which extends [TextView](#). |
| [showProgress](show-progress.md) | `open fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>If [SwipeRefreshLayout](#) is defined, use his progress indicator, otherwise call super |
