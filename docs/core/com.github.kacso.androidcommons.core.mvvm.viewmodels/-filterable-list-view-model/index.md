[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [FilterableListViewModel](./index.md)

# FilterableListViewModel

`abstract class FilterableListViewModel<T, S> : `[`ListViewModel`](../-list-view-model/index.md)`<`[`T`](index.md#T)`>`

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
| [filterTerm](filter-term.md) | `var filterTerm: `[`S`](index.md#S)`?`<br>Current filter set by user |

### Inherited Properties

| Name | Summary |
|---|---|
| [liveData](../-list-view-model/live-data.md) | `open val liveData: MutableLiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../-list-view-model/index.md#T)`>>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [getData](../-list-view-model/get-data.md) | `open fun getData(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](../-list-view-model/index.md#T)`>>`<br>Default implementation will refresh data using [refreshData](../-list-view-model/refresh-data.md) function and return [liveData](../-list-view-model/live-data.md) |
| [refreshData](../-list-view-model/refresh-data.md) | `abstract fun refreshData(forceRefresh: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Refresh [liveData](../-list-view-model/live-data.md) with latest value. |
