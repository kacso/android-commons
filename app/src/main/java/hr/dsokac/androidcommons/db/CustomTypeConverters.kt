package hr.dsokac.androidcommons.db

import androidx.room.TypeConverter
import org.threeten.bp.Instant
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

    @TypeConverter
    fun toInstant(value: String?): Instant? {
        return value?.let { Instant.parse(it) }
    }

    @TypeConverter
    fun fromInstant(value: Instant?): String? {
        return value?.toString()
    }
}