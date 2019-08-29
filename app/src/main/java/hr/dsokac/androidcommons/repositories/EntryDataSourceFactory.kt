package hr.dsokac.androidcommons.repositories

import androidx.paging.DataSource
import hr.dsokac.androidcommons.db.AppDatabase
import hr.dsokac.androidcommons.db.entities.EntryEntity
import hr.dsokac.androidcommons.network.managers.AppNetworkManager


class EntryDataSourceFactory : DataSource.Factory<Int, EntryEntity>() {
    private val entryDao = AppDatabase.getInstance().getEntryDao()
    private val service = AppNetworkManager.getService()

    override fun create(): DataSource<Int, EntryEntity> {
//        return EntryDataSource(entryDao, service)
        return EntryPageDataSource(entryDao, service)
    }
}