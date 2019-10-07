[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [ProgressDialog](./index.md)

# ProgressDialog

`open class ProgressDialog : `[`AbstractProgressDialog`](../-abstract-progress-dialog/index.md)
*

Dialog which indicates that long running task is executing.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ProgressDialog()`<ul><li></li></ul> |

### Functions

| Name | Summary |
|---|---|
| [onCreateView](on-create-view.md) | `open fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View` |

### Inherited Functions

| Name | Summary |
|---|---|
| [dismiss](../-abstract-progress-dialog/dismiss.md) | `open fun dismiss(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [dismissAllowingStateLoss](../-abstract-progress-dialog/dismiss-allowing-state-loss.md) | `open fun dismissAllowingStateLoss(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [isShown](../-abstract-progress-dialog/is-shown.md) | `fun isShown(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [show](../-abstract-progress-dialog/show.md) | `open fun show(manager: FragmentManager, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [newInstance](new-instance.md) | `fun newInstance(): `[`ProgressDialog`](./index.md) |
