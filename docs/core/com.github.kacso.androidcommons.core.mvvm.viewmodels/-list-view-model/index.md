[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [ListViewModel](./index.md)

# ListViewModel

`abstract class ListViewModel<T> : `[`BaseViewModel`](../-base-view-model/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ListViewModel()` |

### Properties

| Name | Summary |
|---|---|
| [liveData](live-data.md) | `open val liveData: MutableLiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](index.md#T)`>>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [error](../-base-view-model/error.md) | `val error: MutableLiveData<ErrorHolder>` |
| [isProgressActive](../-base-view-model/is-progress-active.md) | `val isProgressActive: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [message](../-base-view-model/message.md) | `val message: MutableLiveData<MessageHolder>` |

### Functions

| Name | Summary |
|---|---|
| [getData](get-data.md) | `open fun getData(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](index.md#T)`>>`<br>Default implementation will refresh data using [refreshData](refresh-data.md) function and return [liveData](live-data.md) |
| [refreshData](refresh-data.md) | `abstract fun refreshData(forceRefresh: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Refresh [liveData](live-data.md) with latest value. |

### Inherited Functions

| Name | Summary |
|---|---|
| [getError](../-base-view-model/get-error.md) | `open fun getError(): LiveData<ErrorHolder>` |
| [getIsProgressActive](../-base-view-model/get-is-progress-active.md) | `open fun getIsProgressActive(): LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [getMessage](../-base-view-model/get-message.md) | `open fun getMessage(): LiveData<MessageHolder>` |

### Inheritors

| Name | Summary |
|---|---|
| [FilterableListViewModel](../-filterable-list-view-model/index.md) | `abstract class FilterableListViewModel<T, S> : `[`ListViewModel`](./index.md)`<`[`T`](../-filterable-list-view-model/index.md#T)`>`<br>[ListViewModel](./index.md) which handles filtering |
