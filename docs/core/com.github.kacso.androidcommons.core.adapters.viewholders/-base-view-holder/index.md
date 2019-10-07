[core](../../index.md) / [com.github.kacso.androidcommons.core.adapters.viewholders](../index.md) / [BaseViewHolder](./index.md)

# BaseViewHolder

`abstract class BaseViewHolder<T> : ViewHolder`

Abstract ViewHolder class defining methods required by [LiveDataListAdapter](../../com.github.kacso.androidcommons.core.adapters/-live-data-list-adapter/index.md) and [PagedLiveDataListAdapter](../../com.github.kacso.androidcommons.core.adapters/-paged-live-data-list-adapter/index.md)

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseViewHolder(itemView: View)`<br>Abstract ViewHolder class defining methods required by [LiveDataListAdapter](../../com.github.kacso.androidcommons.core.adapters/-live-data-list-adapter/index.md) and [PagedLiveDataListAdapter](../../com.github.kacso.androidcommons.core.adapters/-paged-live-data-list-adapter/index.md) |

### Functions

| Name | Summary |
|---|---|
| [bind](bind.md) | `abstract fun bind(item: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method called to initialize UI with item data |
