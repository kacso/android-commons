[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [BaseViewModel](./index.md)

# BaseViewModel

`abstract class BaseViewModel : ViewModel, `[`IBaseViewModel`](../-i-base-view-model/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseViewModel()` |

### Properties

| Name | Summary |
|---|---|
| [error](error.md) | `val error: MutableLiveData<ErrorHolder>` |
| [isProgressActive](is-progress-active.md) | `val isProgressActive: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [message](message.md) | `val message: MutableLiveData<MessageHolder>` |

### Functions

| Name | Summary |
|---|---|
| [getError](get-error.md) | `open fun getError(): LiveData<ErrorHolder>` |
| [getIsProgressActive](get-is-progress-active.md) | `open fun getIsProgressActive(): LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [getMessage](get-message.md) | `open fun getMessage(): LiveData<MessageHolder>` |

### Inheritors

| Name | Summary |
|---|---|
| [ListViewModel](../-list-view-model/index.md) | `abstract class ListViewModel<T> : `[`BaseViewModel`](./index.md) |
