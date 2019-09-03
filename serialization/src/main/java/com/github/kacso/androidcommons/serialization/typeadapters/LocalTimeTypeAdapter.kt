package com.github.kacso.androidcommons.serialization.typeadapters

import com.google.gson.*
import org.threeten.bp.LocalTime
import java.lang.reflect.Type


class LocalTimeTypeAdapter : JsonSerializer<LocalTime?>, JsonDeserializer<LocalTime?> {
    override fun serialize(src: LocalTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (src == null) return null
        return JsonPrimitive(src.toString())
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): LocalTime? {
        val jsonPrimitive = json?.asJsonPrimitive ?: return null
        try {
            if (jsonPrimitive.isString) {
                return LocalTime.parse(jsonPrimitive.asString)
            }

        } catch (e: RuntimeException) {
            throw JsonParseException("Unable to parse LocalDate", e)
        }

        throw JsonParseException("Unable to parse LocalDate")
    }
}