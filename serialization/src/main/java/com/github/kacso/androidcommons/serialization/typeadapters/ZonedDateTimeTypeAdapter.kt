package com.github.kacso.androidcommons.serialization.typeadapters

import com.google.gson.*
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import java.lang.reflect.Type


class ZonedDateTimeTypeAdapter : JsonSerializer<ZonedDateTime?>, JsonDeserializer<ZonedDateTime?> {
    override fun serialize(src: ZonedDateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (src == null) return null
        return JsonPrimitive(src.toString())
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): ZonedDateTime? {
        val jsonPrimitive = json?.asJsonPrimitive ?: return null
        try {
            // if provided as String - '2011-12-03T10:15:30+01:00[Europe/Paris]'
            if (jsonPrimitive.isString) {
                return ZonedDateTime.parse(jsonPrimitive.asString)
            }

            // if provided as Long
            if (jsonPrimitive.isNumber) {
                return ZonedDateTime.ofInstant(Instant.ofEpochMilli(jsonPrimitive.asLong), ZoneId.systemDefault())
            }

        } catch (e: RuntimeException) {
            throw JsonParseException("Unable to parse ZonedDateTime", e)
        }

        throw JsonParseException("Unable to parse ZonedDateTime")
    }
}
