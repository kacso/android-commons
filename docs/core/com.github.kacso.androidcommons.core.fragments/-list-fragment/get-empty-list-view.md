[core](../../index.md) / [com.github.kacso.androidcommons.core.fragments](../index.md) / [ListFragment](index.md) / [getEmptyListView](.)

# getEmptyListView

`open fun getEmptyListView(): <ERROR CLASS>?`

Return view that will be displayed to user when there is no data in [RecyclerView](#).
By default it will return [TextView](#) with default message. To change message displayed
call [setEmptyListViewText](set-empty-list-view-text.md).

Override this method if you would like to display more complex view to the user.

**Return**
[View](#) that will be displayed if there is no data in [RecyclerView](#), if null
nothing will be displayed in such situation

