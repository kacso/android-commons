package hr.dsokac.androidcommons.repositories

import android.util.SparseArray
import androidx.paging.PositionalDataSource
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
import kotlin.math.max

class EntryDataSource(
    private val entryDao: EntryDao,
    private val service: AppService
) : PositionalDataSource<EntryEntity>() {
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
                this@EntryDataSource.invalidate()
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

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<EntryEntity>) {
        log(
            tag = "EntryDataSource",
            message = "LoadRange called with loadSize = ${params.loadSize}, startPosition = ${params.startPosition}"
        )
        callback.onResult(
            entryDao.getPagedEntries(
                params.loadSize,
                params.startPosition / params.loadSize * params.loadSize
            )
        )
        refreshPageData(params.loadSize, params.startPosition / params.loadSize)
    }

    private fun computeInitialLoadPosition(params: LoadInitialParams): Int {
        val pageStart = params.requestedStartPosition / params.pageSize * params.pageSize
        return max(0, pageStart)
    }

    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<EntryEntity>
    ) {
        log(
            tag = "EntryDataSource",
            message = "LoadInitial called with pageSize = ${params.pageSize}, requestedLoadSize = ${params.requestedLoadSize}, requestedStartPosition = ${params.requestedStartPosition}"
        )
        val initialPosition = computeInitialLoadPosition(params)
        callback.onResult(
            entryDao.getPagedEntries(params.pageSize, initialPosition),
            initialPosition
        )
        refreshPageData(params.pageSize, initialPosition / params.pageSize)
    }

    private fun refreshPageData(size: Int, page: Int) {
        if (lastSync[page]?.isBefore(Instant.now().minusMillis(10 * 1000L)) == false) return
        GlobalScope.launch {
            runCatching {
                service.getPagedEntries(page + 1, size)
//                service.getEntriesSuspend()
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