[core](../index.md) / [com.github.kacso.androidcommons.core.fragments](./index.md)

## Package com.github.kacso.androidcommons.core.fragments

### Types

| Name | Summary |
|---|---|
| [BaseFragment](-base-fragment/index.md) | `abstract class BaseFragment : Fragment, `[`BaseView`](../com.github.kacso.androidcommons.core.views/-base-view/index.md)<br>Abstract [Fragment](#) class which implements common functionalities from [BaseView](../com.github.kacso.androidcommons.core.views/-base-view/index.md) and solves most common tasks in Fragment. |
| [FilterableListFragment](-filterable-list-fragment/index.md) | `abstract class FilterableListFragment<T> : `[`ListFragment`](-list-fragment/index.md)`<`[`T`](-filterable-list-fragment/index.md#T)`>`<br>This class provides default implementation for fragments with [RecyclerView](#) and search field |
| [ListFragment](-list-fragment/index.md) | `abstract class ListFragment<T> : `[`BaseFragment`](-base-fragment/index.md)<br>This class provides default implementation for fragments with [RecyclerView](#) |
| [PageFragment](-page-fragment/index.md) | `abstract class PageFragment : `[`BaseFragment`](-base-fragment/index.md)`, `[`PageView`](../com.github.kacso.androidcommons.core.views/-page-view/index.md)<br>Abstract class for fragments which are used in ViewPager. |
| [PageListFragment](-page-list-fragment/index.md) | `abstract class PageListFragment<T> : `[`PageFragment`](-page-fragment/index.md)`, `[`PageView`](../com.github.kacso.androidcommons.core.views/-page-view/index.md)<br>Abstract class for fragments which are used in ViewPager and are displaying list in [RecyclerView](#). |
| [PagerFragment](-pager-fragment/index.md) | `abstract class PagerFragment : `[`BaseFragment`](-base-fragment/index.md)`, `[`PagerView`](../com.github.kacso.androidcommons.core.views/-pager-view/index.md)<br>Abstract class with common functionalities which are used in fragment with [ViewPager](#) |
