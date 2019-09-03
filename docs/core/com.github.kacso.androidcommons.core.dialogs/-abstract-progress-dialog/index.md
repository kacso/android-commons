[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [AbstractProgressDialog](.)

# AbstractProgressDialog

`abstract class AbstractProgressDialog`

Class which implements common functionalities needed for progress dialogs
and makes abstraction for other components when accessing real implementation.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractProgressDialog()`<br>Class which implements common functionalities needed for progress dialogs
and makes abstraction for other components when accessing real implementation. |

### Functions

| Name | Summary |
|---|---|
| [dismiss](dismiss.md) | `open fun dismiss(): Unit` |
| [dismissAllowingStateLoss](dismiss-allowing-state-loss.md) | `open fun dismissAllowingStateLoss(): Unit` |
| [isShown](is-shown.md) | `fun isShown(): Boolean` |
| [show](show.md) | `open fun show(manager: <ERROR CLASS>, tag: String?): Unit` |

### Inheritors

| Name | Summary |
|---|---|
| [ProgressDialog](../-progress-dialog/index.md) | `open class ProgressDialog : AbstractProgressDialog`<ul><li></li></ul> |
