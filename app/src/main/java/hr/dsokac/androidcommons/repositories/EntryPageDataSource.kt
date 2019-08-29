package hr.dsokac.androidcommons.repositories

import android.util.SparseArray
import androidx.paging.PageKeyedDataSource
import androidx.room.InvalidationTracker
import hr.dsokac.androidcommons.db.AppDatabase
import hr.dsokac.androidcommons.db.dao.EntryDao
import hr.dsokac.androidcommons.db.entities.EntryEntity
import hr.dsokac.androidcommons.logger.log
import hr.dsokac.androidcommons.mappers.toEntity
import hr.dsokac.androidcommons.network.services.AppService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.threeten.bp.Instant

class EntryPageDataSource(
    private val entryDao: EntryDao,
    private val service: AppService
) : PageKeyedDataSource<Int, EntryEntity>() {
    companion object {
        val lastSync = SparseArray<Instant>()
    }


    private val invalidationTracker =
        object : InvalidationTracker.Observer(EntryEntity.TABLE_NAME) {
            override fun onInvalidated(tables: MutableSet<String>) {
                log(
                    tag = "EntryDataSource",
                    message = "Invalidating data source because following tables were invalidated $tables"
                )
                this@EntryPageDataSource.invalidate()
            }
        }

    init {
        AppDatabase.getInstance().invalidationTracker.addObserver(invalidationTracker)
    }

    override fun invalidate() {
        GlobalScope.launch {
            AppDatabase.getInstance().invalidationTracker.removeObserver(invalidationTracker)
        }
        super.invalidate()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, EntryEntity>
    ) {
        log(
            tag = "EntryDataSource",
            message = "LoadInitial called with requestedLoadSize = ${params.requestedLoadSize}"
        )
        //Get first page from DB and notify callback
        val data = entryDao.getPagedEntries(params.requestedLoadSize, 0)
        callback.onResult(
            data,
            null,
            1
        )

        //Update data from network if needed
        refreshPageData(params.requestedLoadSize, 0)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, EntryEntity>) {
        log(
            tag = "EntryDataSource",
            message = "LoadRange called with loadSize = ${params.requestedLoadSize}, key = ${params.key}"
        )
        //Get new page from DB and notify callback
        callback.onResult(
            entryDao.getPagedEntries(
                params.requestedLoadSize,
                params.key * params.requestedLoadSize
            ),
            params.key + 1
        )
        //Update data from network if needed
        refreshPageData(params.requestedLoadSize, params.key)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, EntryEntity>) {
    }

    private fun refreshPageData(size: Int, page: Int) {
        if (lastSync[page]?.isBefore(Instant.now().minusMillis(10 * 1000L)) == false) return
        GlobalScope.launch {
            runCatching {
                service.getPagedEntries(page + 1, size)
            }.onSuccess {
                lastSync.put(page, Instant.now())
                entryDao.upsert(it.map { it.toEntity() })
                log("EntryDataSource", it.toString())
            }.onFailure {
                it.log()
            }
        }
    }
}