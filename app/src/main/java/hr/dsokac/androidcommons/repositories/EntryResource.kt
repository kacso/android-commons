package hr.dsokac.androidcommons.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import hr.dsokac.androidcommons.core.repository.NetworkBoundResource
import hr.dsokac.androidcommons.db.dao.EntryDao
import hr.dsokac.androidcommons.mappers.toEntity
import hr.dsokac.androidcommons.mappers.toEntry
import hr.dsokac.androidcommons.models.network.ApiEntry
import hr.dsokac.androidcommons.models.ui.Entry
import hr.dsokac.androidcommons.network.models.ApiResponse
import hr.dsokac.androidcommons.network.services.AppService
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