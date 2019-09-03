[core](../../index.md) / [com.github.kacso.androidcommons.core.adapters](../index.md) / [LiveDataListAdapter](.)

# LiveDataListAdapter

`abstract class LiveDataListAdapter<T : Any, VH : `[`BaseViewHolder`](../../com.github.kacso.androidcommons.core.adapters.viewholders/-base-view-holder/index.md)`<T>>`

Abstract implementation of [RecyclerView.Adapter](#) which works with [LiveData](#) list.
This adapter will automatically update list when live data emit changes.

### Parameters

`T` - Type of single list item

`VH` - ViewHolder type

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LiveDataListAdapter(items: <ERROR CLASS><List<T>>, lifecycleOwner: <ERROR CLASS>, diffUtilCallback: <ERROR CLASS><T> = DefaultDiffUtilsItemCallback())`<br>Abstract implementation of [RecyclerView.Adapter](#) which works with [LiveData](#) list.
This adapter will automatically update list when live data emit changes. |

### Properties

| Name | Summary |
|---|---|
| [itemLayoutRes](item-layout-res.md) | `abstract val itemLayoutRes: Int`<br>Returns layout to be used for displaying list item |
| [recyclerView](recycler-view.md) | `lateinit var recyclerView: <ERROR CLASS>` |

### Functions

| Name | Summary |
|---|---|
| [createViewHolder](create-view-holder.md) | `abstract fun createViewHolder(view: <ERROR CLASS>): VH`<br>Method called when new ViewHolder needs to be created |
| [onAttachedToRecyclerView](on-attached-to-recycler-view.md) | `open fun onAttachedToRecyclerView(recyclerView: <ERROR CLASS>): Unit` |
| [onBindViewHolder](on-bind-view-holder.md) | `open fun onBindViewHolder(holder: VH, position: Int): Unit` |
| [onCreateViewHolder](on-create-view-holder.md) | `open fun onCreateViewHolder(parent: <ERROR CLASS>, viewType: Int): VH` |
