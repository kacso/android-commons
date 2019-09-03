[core](../../index.md) / [com.github.kacso.androidcommons.core.views](../index.md) / [PageView](.)

# PageView

`interface PageView`

Interface which defines basic functionalities of single page of [PagerView](../-pager-view/index.md)

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [getTitleRes](get-title-res.md) | `abstract fun getTitleRes(): Int`<br>Function to retrieve title of page |

### Inheritors

| Name | Summary |
|---|---|
| [PageFragment](../../com.github.kacso.androidcommons.core.fragments/-page-fragment/index.md) | `abstract class PageFragment : `[`BaseFragment`](../../com.github.kacso.androidcommons.core.fragments/-base-fragment/index.md)`, PageView`<br>Abstract class for fragments which are used in ViewPager. |
| [PageListFragment](../../com.github.kacso.androidcommons.core.fragments/-page-list-fragment/index.md) | `abstract class PageListFragment<T> : `[`PageFragment`](../../com.github.kacso.androidcommons.core.fragments/-page-fragment/index.md)`, PageView`<br>Abstract class for fragments which are used in ViewPager and are displaying list in [RecyclerView](#). |
