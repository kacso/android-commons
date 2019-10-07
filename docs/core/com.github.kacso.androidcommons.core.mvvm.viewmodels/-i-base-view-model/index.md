[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [IBaseViewModel](./index.md)

# IBaseViewModel

`interface IBaseViewModel`

### Functions

| Name | Summary |
|---|---|
| [getError](get-error.md) | `abstract fun getError(): LiveData<ErrorHolder>` |
| [getIsProgressActive](get-is-progress-active.md) | `abstract fun getIsProgressActive(): LiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [getMessage](get-message.md) | `abstract fun getMessage(): LiveData<MessageHolder>` |

### Inheritors

| Name | Summary |
|---|---|
| [AndroidBaseViewModel](../-android-base-view-model/index.md) | `abstract class AndroidBaseViewModel : AndroidViewModel, `[`IBaseViewModel`](./index.md) |
| [BaseViewModel](../-base-view-model/index.md) | `abstract class BaseViewModel : ViewModel, `[`IBaseViewModel`](./index.md) |
