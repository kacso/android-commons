[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [ListViewModel](.)

# ListViewModel

`abstract class ListViewModel<T> : `[`BaseViewModel`](../-base-view-model/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ListViewModel()` |

### Properties

| Name | Summary |
|---|---|
| [liveData](live-data.md) | `open val liveData: <ERROR CLASS>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [error](../-base-view-model/error.md) | `val error: <ERROR CLASS><<ERROR CLASS>>` |
| [isProgressActive](../-base-view-model/is-progress-active.md) | `val isProgressActive: <ERROR CLASS><Boolean>` |
| [message](../-base-view-model/message.md) | `val message: <ERROR CLASS><<ERROR CLASS>>` |

### Functions

| Name | Summary |
|---|---|
| [getData](get-data.md) | `open fun getData(): <ERROR CLASS><List<T>>`<br>Default implementation will refresh data using [refreshData](refresh-data.md) function and return [liveData](live-data.md) |
| [refreshData](refresh-data.md) | `abstract fun refreshData(): Unit` |

### Inherited Functions

| Name | Summary |
|---|---|
| [getError](../-base-view-model/get-error.md) | `open fun getError(): <ERROR CLASS><<ERROR CLASS>>` |
| [getIsProgressActive](../-base-view-model/get-is-progress-active.md) | `open fun getIsProgressActive(): <ERROR CLASS><Boolean>` |
| [getMessage](../-base-view-model/get-message.md) | `open fun getMessage(): <ERROR CLASS><<ERROR CLASS>>` |
