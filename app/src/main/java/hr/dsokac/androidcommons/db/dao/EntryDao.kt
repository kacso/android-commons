package hr.dsokac.androidcommons.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import hr.dsokac.androidcommons.db.entities.EntryEntity

@Dao
abstract class EntryDao : BaseDao<EntryEntity>() {
    @Query("SELECT * FROM ${EntryEntity.TABLE_NAME} ORDER BY ${EntryEntity.COLUMN_DATE} DESC")
    abstract fun getEntries(): LiveData<List<EntryEntity>>

    @Query("SELECT * FROM ${EntryEntity.TABLE_NAME} ORDER BY ${EntryEntity.COLUMN_DATE} DESC")
    abstract fun getPagedEntries(): DataSource.Factory<Int, EntryEntity>

    @Query("SELECT * FROM ${EntryEntity.TABLE_NAME} ORDER BY ${EntryEntity.COLUMN_DATE} DESC LIMIT :limit OFFSET :offset")
    abstract fun getPagedEntries(limit: Int, offset: Int): List<EntryEntity>
}