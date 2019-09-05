package com.github.kacso.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.github.kacso.androidcommons.core.mvvm.viewmodels.FilterableListViewModel
import com.github.kacso.androidcommons.data.Resource
import com.github.kacso.androidcommons.db.AppDatabase
import com.github.kacso.androidcommons.extensions.matches
import com.github.kacso.androidcommons.logger.log
import com.github.kacso.androidcommons.models.ui.Entry
import com.github.kacso.androidcommons.network.managers.AppNetworkManager
import com.github.kacso.androidcommons.repositories.EntryResource

class EntryFilterableListViewModel : FilterableListViewModel<Entry, String>() {
    private val entryResource = EntryResource(
        entryDao = AppDatabase.getInstance().getEntryDao(),
        service = AppNetworkManager.getService()
    )

    private var entries: MutableList<Entry>? = null
        set(value) {
            field = value
            filter()
        }

    private var entryResourceLiveData: LiveData<Resource<List<Entry>>>? = null

    override val liveData: MediatorLiveData<List<Entry>> = MediatorLiveData()

    override fun refreshData(forceRefresh: Boolean) {
        entryResourceLiveData?.let {
            liveData.removeSource(it)
        }

        //Fetch only during initial load or on swipe to refresh
        if (entries.isNullOrEmpty() || forceRefresh) {
            entryResource.asLiveData().let { src ->
                entryResourceLiveData = src
                liveData.addSource(src) { res ->
                    when (res) {
                        is Resource.Loading -> {
                            log(message = "Loading entry list")
                            isProgressActive.postValue(true)
                            res.data?.apply {
                                entries = toMutableList()
                            }
                        }
                        is Resource.Error -> {
                            res.error?.cause?.log()
                            isProgressActive.postValue(false)
                            error.postValue(res.error)
                        }
                        is Resource.Success -> {
                            log(message = "Successfully loaded entries")
                            isProgressActive.postValue(false)
                            entries = res.data?.toMutableList()
                        }
                    }
                }
            }
        } else {
            filter()
        }
    }

    private fun filter() {
        entries?.filter {
            listOf(
                it.date.toString(),
                it.value
            ).matches(filterTerm)
        }.apply {
            liveData.postValue(this)
        }
    }
}