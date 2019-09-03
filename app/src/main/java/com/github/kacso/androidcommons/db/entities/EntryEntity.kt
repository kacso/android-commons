package com.github.kacso.androidcommons.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.kacso.androidcommons.db.entities.EntryEntity.Companion.TABLE_NAME
import org.threeten.bp.Instant

@Entity(tableName = TABLE_NAME)
data class EntryEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = COLUMN_ID)
    val id: Long,
    @ColumnInfo(name = COLUMN_DATE)
    val date: Instant,
    @ColumnInfo(name = COLUMN_VALUE)
    val value: String
) {
    companion object {
        const val TABLE_NAME = "EntryEntity"
        const val COLUMN_ID = "id"
        const val COLUMN_DATE = "date"
        const val COLUMN_VALUE = "value"
    }
}