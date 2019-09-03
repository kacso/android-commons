[core](../../index.md) / [com.github.kacso.androidcommons.core.adapters](../index.md) / [LiveDataListAdapter](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`LiveDataListAdapter(items: <ERROR CLASS><List<T>>, lifecycleOwner: <ERROR CLASS>, diffUtilCallback: <ERROR CLASS><T> = DefaultDiffUtilsItemCallback())`

Abstract implementation of [RecyclerView.Adapter](#) which works with [LiveData](#) list.
This adapter will automatically update list when live data emit changes.

### Parameters

`T` - Type of single list item

`VH` - ViewHolder type