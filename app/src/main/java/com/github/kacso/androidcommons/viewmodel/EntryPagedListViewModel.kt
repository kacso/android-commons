package com.github.kacso.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.github.kacso.androidcommons.core.mvvm.viewmodels.ListViewModel
import com.github.kacso.androidcommons.db.AppDatabase
import com.github.kacso.androidcommons.mappers.toEntry
import com.github.kacso.androidcommons.models.ui.Entry

class EntryPagedListViewModel : ListViewModel<Entry>() {
    private val entryDao = AppDatabase.getInstance().getEntryDao()

    override val liveData: MediatorLiveData<List<Entry>> = MediatorLiveData()

    override fun refreshData(forceRefresh: Boolean) {
        isProgressActive.postValue(true)
        entryResourceLiveData?.let {
            liveData.removeSource(it)
        }
        val entriesFactory = entryDao.getPagedEntries()

        val src = entriesFactory.map { it.toEntry() }
            .toLiveData(pageSize = 10)

        entryResourceLiveData = src
        liveData.addSource(src) { res ->
            isProgressActive.postValue(false)
            liveData.postValue(res)
        }
    }

    private var entryResourceLiveData: LiveData<PagedList<Entry>>? = null
}