[core](../../index.md) / [com.github.kacso.androidcommons.core.views](../index.md) / [PagerView](./index.md)

# PagerView

`interface PagerView`

Interface which defines basic functionalities of view with ViewPager

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [getFragments](get-fragments.md) | `abstract fun getFragments(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PageFragment`](../../com.github.kacso.androidcommons.core.fragments/-page-fragment/index.md)`>`<br>Function to retrieve fragments for [ViewPager](#) |

### Inheritors

| Name | Summary |
|---|---|
| [PagerFragment](../../com.github.kacso.androidcommons.core.fragments/-pager-fragment/index.md) | `abstract class PagerFragment : `[`BaseFragment`](../../com.github.kacso.androidcommons.core.fragments/-base-fragment/index.md)`, `[`PagerView`](./index.md)<br>Abstract class with common functionalities which are used in fragment with [ViewPager](#) |
