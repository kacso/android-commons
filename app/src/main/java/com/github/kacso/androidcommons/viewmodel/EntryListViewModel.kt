package com.github.kacso.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.github.kacso.androidcommons.core.mvvm.viewmodels.ListViewModel
import com.github.kacso.androidcommons.data.Resource
import com.github.kacso.androidcommons.db.AppDatabase
import com.github.kacso.androidcommons.logger.log
import com.github.kacso.androidcommons.models.ui.Entry
import com.github.kacso.androidcommons.network.managers.AppNetworkManager
import com.github.kacso.androidcommons.repositories.EntryResource

class EntryListViewModel : ListViewModel<Entry>() {
    private val entryResource = EntryResource(
        entryDao = AppDatabase.getInstance().getEntryDao(),
        service = AppNetworkManager.getService()
    )

    override val liveData: MediatorLiveData<List<Entry>> = MediatorLiveData()

    override fun refreshData(forceRefresh: Boolean) {
        entryResourceLiveData?.let {
            liveData.removeSource(it)
        }

        entryResource.asLiveData().let { src ->
            entryResourceLiveData = src
            liveData.addSource(src) { res ->
                when (res) {
                    is Resource.Loading -> {
                        log(message = "Loading entry list")
                        isProgressActive.postValue(true)
                        res.data?.apply {
                            liveData.postValue(this)
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
                        liveData.postValue(res.data)
                    }
                }
            }
        }
    }

    private var entryResourceLiveData: LiveData<Resource<List<Entry>>>? = null
}