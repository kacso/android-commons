[core](../../index.md) / [com.github.kacso.androidcommons.core.adapters](../index.md) / [LiveDataListAdapter](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`LiveDataListAdapter(items: LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](index.md#T)`>>, lifecycleOwner: LifecycleOwner, diffUtilCallback: ItemCallback<`[`T`](index.md#T)`> = DefaultDiffUtilsItemCallback())`

Abstract implementation of [RecyclerView.Adapter](#) which works with [LiveData](#) list.
This adapter will automatically update list when live data emit changes.

### Parameters

`T` - Type of single list item

`VH` - ViewHolder type