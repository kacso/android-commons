package com.github.kacso.androidcommons.core.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class ListViewModel<T> : BaseViewModel() {
    protected open val liveData = MutableLiveData<List<T>>()

    /**
     * Default implementation will refresh data using [refreshData] function and return [liveData]
     *
     * @return [liveData]
     */
    open fun getData(): LiveData<List<T>> {
        refreshData()
        return liveData
    }

    /**
     * Refresh [liveData] with latest value.
     *
     * @param forceRefresh If false, cached value is valid to be used, otherwise refresh data from original source (e.g. fetch from network on swipe to refresh)
     */
    abstract fun refreshData(forceRefresh: Boolean = false)
}