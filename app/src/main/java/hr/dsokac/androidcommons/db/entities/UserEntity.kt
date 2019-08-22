package hr.dsokac.androidcommons.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hr.dsokac.androidcommons.db.entities.UserEntity.Companion.TABLE_NAME
import java.util.*

@Entity(tableName = TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = COLUMN_ID)
    val id: UUID,
    @ColumnInfo(name = COLUMN_FIRST_NAME)
    val firstName: String,
    @ColumnInfo(name = COLUMN_LAST_NAME)
    val lastName: String,
    @ColumnInfo(name = COLUMN_EMAIL)
    val email: String
) {
    companion object {
        const val TABLE_NAME = "UserEntity"
        const val COLUMN_ID = "id"
        const val COLUMN_FIRST_NAME = "firstName"
        const val COLUMN_LAST_NAME = "lastName"
        const val COLUMN_EMAIL = "email"
    }
}