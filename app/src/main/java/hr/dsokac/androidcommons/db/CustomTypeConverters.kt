package hr.dsokac.androidcommons.db

import androidx.room.TypeConverter
import java.util.*

class CustomTypeConverters {
    @TypeConverter
    fun toUUID(value: String?): UUID? {
        return value?.let { UUID.fromString(it) }
    }

    @TypeConverter
    fun fromUUID(value: UUID?): String? {
        return value?.toString()
    }
}