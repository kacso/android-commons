[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [AndroidBaseViewModel](./index.md)

# AndroidBaseViewModel

`abstract class AndroidBaseViewModel : AndroidViewModel, `[`IBaseViewModel`](../-i-base-view-model/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AndroidBaseViewModel(application: Application)` |

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
