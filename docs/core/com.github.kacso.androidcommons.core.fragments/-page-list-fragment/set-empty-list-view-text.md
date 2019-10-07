[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [PageListFragment](index.md) / [setEmptyListViewText](./set-empty-list-view-text.md)

# setEmptyListViewText

`open fun setEmptyListViewText(msg: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set [msg](set-empty-list-view-text.md#com.github.kacso.androidcommons.core.fragments.PageListFragment$setEmptyListViewText(kotlin.String)/msg) as text that should be displayed to user when there is no data in [RecyclerView](#).
This function will work with any [View](#) returned from [getEmptyListView](get-empty-list-view.md) which extends [TextView](#).

If you are using custom [View](#), make sure that it extends [TextView](#) or override this
function and give your implementation of setting text message.

### Parameters

`msg` - text to be displayed to user inside [View](#) returned by [getEmptyListView](get-empty-list-view.md)