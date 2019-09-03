package com.github.kacso.androidcommons.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.github.kacso.androidcommons.core.repository.NetworkBoundResource
import com.github.kacso.androidcommons.db.dao.EntryDao
import com.github.kacso.androidcommons.mappers.toEntity
import com.github.kacso.androidcommons.mappers.toEntry
import com.github.kacso.androidcommons.models.network.ApiEntry
import com.github.kacso.androidcommons.models.ui.Entry
import com.github.kacso.androidcommons.network.models.ApiResponse
import com.github.kacso.androidcommons.network.services.AppService
import kotlin.coroutines.suspendCoroutine

class EntryResource(
    private val entryDao: EntryDao,
    private val service: AppService
) : NetworkBoundResource<List<Entry>, List<ApiEntry>>() {
    override suspend fun saveCallResult(item: List<ApiEntry>) {
        return suspendCoroutine {
            entryDao.upsert(item.map { it.toEntity() })
        }
    }

    override fun loadFromDb(): LiveData<List<Entry>> {
        return Transformations.map(entryDao.getEntries()) {
            it?.map {
                it.toEntry()
            }
        }
    }

    override fun createCall(): LiveData<ApiResponse<List<ApiEntry>>> {
        return service.getEntries()
    }

    override fun shouldFetch(data: List<Entry>?): Boolean = true
}