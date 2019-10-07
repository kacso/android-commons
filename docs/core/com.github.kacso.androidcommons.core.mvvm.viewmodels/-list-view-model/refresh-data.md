[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [ListViewModel](index.md) / [refreshData](./refresh-data.md)

# refreshData

`abstract fun refreshData(forceRefresh: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Refresh [liveData](live-data.md) with latest value.

### Parameters

`forceRefresh` - If false, cached value is valid to be used, otherwise refresh data from original source (e.g. fetch from network on swipe to refresh)