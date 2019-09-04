package com.github.kacso.androidcommons.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.github.kacso.androidcommons.db.entities.EntryEntity

@Dao
abstract class EntryDao : BaseDao<EntryEntity>() {
    @Query("SELECT * FROM ${EntryEntity.TABLE_NAME} ORDER BY ${EntryEntity.COLUMN_DATE} DESC")
    abstract fun getEntries(): LiveData<List<EntryEntity>>

    @Query("SELECT * FROM ${EntryEntity.TABLE_NAME} ORDER BY ${EntryEntity.COLUMN_DATE} DESC")
    abstract fun getPagedEntries(): DataSource.Factory<Int, EntryEntity>
}