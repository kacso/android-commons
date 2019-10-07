[core](../../index.md) / [com.github.kacso.androidcommons.core.adapters](../index.md) / [PagedLiveDataListAdapter](./index.md)

# PagedLiveDataListAdapter

`abstract class PagedLiveDataListAdapter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, VH : `[`BaseViewHolder`](../../com.github.kacso.androidcommons.core.adapters.viewholders/-base-view-holder/index.md)`<`[`T`](index.md#T)`>> : PagedListAdapter<`[`T`](index.md#T)`, `[`VH`](index.md#VH)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PagedLiveDataListAdapter(items: LiveData<PagedList<`[`T`](index.md#T)`>>, lifecycleOwner: LifecycleOwner, diffUtilCallback: ItemCallback<`[`T`](index.md#T)`> = DefaultDiffUtilsItemCallback())` |

### Properties

| Name | Summary |
|---|---|
| [itemLayoutRes](item-layout-res.md) | `abstract val itemLayoutRes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns layout to be used for displaying list item |

### Functions

| Name | Summary |
|---|---|
| [createViewHolder](create-view-holder.md) | `abstract fun createViewHolder(view: View): `[`VH`](index.md#VH)<br>Method called when new ViewHolder needs to be created |
| [onAttachedToRecyclerView](on-attached-to-recycler-view.md) | `open fun onAttachedToRecyclerView(recyclerView: RecyclerView): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `open fun onBindViewHolder(holder: `[`VH`](index.md#VH)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `open fun onCreateViewHolder(parent: ViewGroup, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`VH`](index.md#VH) |
