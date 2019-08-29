package hr.dsokac.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.paging.Config
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import hr.dsokac.androidcommons.core.mvvm.viewmodels.ListViewModel
import hr.dsokac.androidcommons.db.AppDatabase
import hr.dsokac.androidcommons.mappers.toEntry
import hr.dsokac.androidcommons.models.ui.Entry
import hr.dsokac.androidcommons.network.managers.AppNetworkManager
import hr.dsokac.androidcommons.repositories.EntryDataSourceFactory

class EntryPagedListViewModel : ListViewModel<Entry>() {
    private val entryDao = AppDatabase.getInstance().getEntryDao()
    private val service = AppNetworkManager.getService()

    override val liveData: MediatorLiveData<List<Entry>> = MediatorLiveData()

    override fun refreshData() {
        entryResourceLiveData?.let {
            liveData.removeSource(it)
        }
//        val entriesFactory = entryDao.getPagedEntries()
        val entriesFactory = EntryDataSourceFactory()

//        val src = entriesFactory.mapByPage {
//            it.map {
//                it.toEntry()
//            }
//        }.toLiveData(
//            pageSize = 10,
//            boundaryCallback = EntryBoundaryCallback(),
//            initialLoadKey = 0
//        )

        val src = LivePagedListBuilder(
            entriesFactory.map { it.toEntry() },
            Config(pageSize = 10, enablePlaceholders = false, initialLoadSizeHint = 10)
        )
            .setInitialLoadKey(0)
            .build()
        entryResourceLiveData = src
        liveData.addSource(src) { res ->
            liveData.postValue(res)
        }

    }

    private var entryResourceLiveData: LiveData<PagedList<Entry>>? = null
}