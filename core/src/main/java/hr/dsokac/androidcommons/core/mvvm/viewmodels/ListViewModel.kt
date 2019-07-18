package hr.dsokac.androidcommons.core.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class ListViewModel<T> : BaseViewModel() {
    protected val liveData = MutableLiveData<List<T>>()

    /**
     * Default implementation will refresh data using [refreshData] function and return [liveData]
     *
     * @return [liveData]
     */
    open fun getData(): LiveData<List<T>> {
        refreshData()
        return liveData
    }

    abstract fun refreshData()
}