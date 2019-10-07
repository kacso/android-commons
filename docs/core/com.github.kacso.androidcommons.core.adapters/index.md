[core](../index.md) / [com.github.kacso.androidcommons.core.adapters](./index.md)

## Package com.github.kacso.androidcommons.core.adapters

### Types

| Name | Summary |
|---|---|
| [AbstractSectionListAdapter](-abstract-section-list-adapter/index.md) | `abstract class AbstractSectionListAdapter : ListAdapter<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, `[`AbstractSectionViewHolder`](../com.github.kacso.androidcommons.core.adapters.viewholders/-abstract-section-view-holder/index.md)`>, `[`StickyHeaderInterface`](../com.github.kacso.androidcommons.core.adapters.utils/-header-item-decoration/-sticky-header-interface/index.md)<br>Abstract implementation of [RecyclerView.Adapter](#) which works with [LiveData](#) list and groups list items into sections. This adapter provides support for multiple header and subitem types. This adapter will automatically update list when live data emit changes. |
| [LiveDataListAdapter](-live-data-list-adapter/index.md) | `abstract class LiveDataListAdapter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, VH : `[`BaseViewHolder`](../com.github.kacso.androidcommons.core.adapters.viewholders/-base-view-holder/index.md)`<`[`T`](-live-data-list-adapter/index.md#T)`>> : ListAdapter<`[`T`](-live-data-list-adapter/index.md#T)`, `[`VH`](-live-data-list-adapter/index.md#VH)`>`<br>Abstract implementation of [RecyclerView.Adapter](#) which works with [LiveData](#) list. This adapter will automatically update list when live data emit changes. |
| [PagedLiveDataListAdapter](-paged-live-data-list-adapter/index.md) | `abstract class PagedLiveDataListAdapter<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, VH : `[`BaseViewHolder`](../com.github.kacso.androidcommons.core.adapters.viewholders/-base-view-holder/index.md)`<`[`T`](-paged-live-data-list-adapter/index.md#T)`>> : PagedListAdapter<`[`T`](-paged-live-data-list-adapter/index.md#T)`, `[`VH`](-paged-live-data-list-adapter/index.md#VH)`>` |
