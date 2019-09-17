[core](../../index.md) / [com.github.kacso.androidcommons.core.mvvm.viewmodels](../index.md) / [ListViewModel](index.md) / [refreshData](.)

# refreshData

`abstract fun refreshData(forceRefresh: Boolean = false): Unit`

Refresh [liveData](live-data.md) with latest value.

### Parameters

`forceRefresh` - If false, cached value is valid to be used, otherwise refresh data from original source (e.g. fetch from network on swipe to refresh)