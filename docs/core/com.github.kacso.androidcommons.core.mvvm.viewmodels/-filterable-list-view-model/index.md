[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [FilterableListViewModel](.)

# FilterableListViewModel

`abstract class FilterableListViewModel<T, S> : `[`ListViewModel`](../-list-view-model/index.md)`<T>`

[ListViewModel](../-list-view-model/index.md) which handles filtering

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FilterableListViewModel()`<br>[ListViewModel](../-list-view-model/index.md) which handles filtering |

### Properties

| Name | Summary |
|---|---|
| [filterTerm](filter-term.md) | `var filterTerm: S?`<br>Current filter set by user |

### Inherited Properties

| Name | Summary |
|---|---|
| [liveData](../-list-view-model/live-data.md) | `open val liveData: <ERROR CLASS>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [getData](../-list-view-model/get-data.md) | `open fun getData(): <ERROR CLASS><List<T>>`<br>Default implementation will refresh data using [refreshData](../-list-view-model/refresh-data.md) function and return [liveData](../-list-view-model/live-data.md) |
| [refreshData](../-list-view-model/refresh-data.md) | `abstract fun refreshData(forceRefresh: Boolean = false): Unit`<br>Refresh [liveData](../-list-view-model/live-data.md) with latest value. |
