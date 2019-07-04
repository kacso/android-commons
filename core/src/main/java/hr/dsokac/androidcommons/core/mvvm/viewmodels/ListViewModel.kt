package hr.dsokac.androidcommons.core.mvvm.viewmodels

import androidx.lifecycle.LiveData

abstract class ListViewModel<T> : BaseViewModel() {
    abstract fun getData(): LiveData<List<T>>
    abstract fun refreshData()
}