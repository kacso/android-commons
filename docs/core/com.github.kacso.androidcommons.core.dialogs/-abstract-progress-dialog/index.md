[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [AbstractProgressDialog](./index.md)

# AbstractProgressDialog

`abstract class AbstractProgressDialog : DialogFragment`

Class which implements common functionalities needed for progress dialogs
and makes abstraction for other components when accessing real implementation.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractProgressDialog()`<br>Class which implements common functionalities needed for progress dialogs and makes abstraction for other components when accessing real implementation. |

### Functions

| Name | Summary |
|---|---|
| [dismiss](dismiss.md) | `open fun dismiss(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [dismissAllowingStateLoss](dismiss-allowing-state-loss.md) | `open fun dismissAllowingStateLoss(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [isShown](is-shown.md) | `fun isShown(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [show](show.md) | `open fun show(manager: FragmentManager, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ProgressDialog](../-progress-dialog/index.md) | `open class ProgressDialog : `[`AbstractProgressDialog`](./index.md)<ul><li></li></ul> |
