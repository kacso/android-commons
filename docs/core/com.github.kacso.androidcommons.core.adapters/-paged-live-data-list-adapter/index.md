[core](../../index.md) / [com.github.kacso.androidcommons.core.adapters](../index.md) / [PagedLiveDataListAdapter](.)

# PagedLiveDataListAdapter

`abstract class PagedLiveDataListAdapter<T : Any, VH : `[`BaseViewHolder`](../../com.github.kacso.androidcommons.core.adapters.viewholders/-base-view-holder/index.md)`<T>>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PagedLiveDataListAdapter(items: <ERROR CLASS><<ERROR CLASS><T>>, lifecycleOwner: <ERROR CLASS>, diffUtilCallback: <ERROR CLASS><T> = DefaultDiffUtilsItemCallback())` |

### Properties

| Name | Summary |
|---|---|
| [itemLayoutRes](item-layout-res.md) | `abstract val itemLayoutRes: Int`<br>Returns layout to be used for displaying list item |

### Functions

| Name | Summary |
|---|---|
| [createViewHolder](create-view-holder.md) | `abstract fun createViewHolder(view: <ERROR CLASS>): VH`<br>Method called when new ViewHolder needs to be created |
| [onAttachedToRecyclerView](on-attached-to-recycler-view.md) | `open fun onAttachedToRecyclerView(recyclerView: <ERROR CLASS>): Unit` |
| [onBindViewHolder](on-bind-view-holder.md) | `open fun onBindViewHolder(holder: VH, position: Int): Unit` |
| [onCreateViewHolder](on-create-view-holder.md) | `open fun onCreateViewHolder(parent: <ERROR CLASS>, viewType: Int): VH` |
