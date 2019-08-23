package hr.dsokac.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import hr.dsokac.androidcommons.core.mvvm.viewmodels.ListViewModel
import hr.dsokac.androidcommons.data.Resource
import hr.dsokac.androidcommons.db.AppDatabase
import hr.dsokac.androidcommons.logger.log
import hr.dsokac.androidcommons.models.ui.Entry
import hr.dsokac.androidcommons.network.managers.AppNetworkManager
import hr.dsokac.androidcommons.repositories.EntryResource

class EntryListViewModel : ListViewModel<Entry>() {
    private val entryResource = EntryResource(
        entryDao = AppDatabase.getInstance().getEntryDao(),
        service = AppNetworkManager.getService()
    )

    override val liveData: MediatorLiveData<List<Entry>> = MediatorLiveData()

    override fun refreshData() {
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