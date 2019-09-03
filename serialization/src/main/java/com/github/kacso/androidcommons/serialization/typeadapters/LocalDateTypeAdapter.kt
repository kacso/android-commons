package com.github.kacso.androidcommons.serialization.typeadapters

import com.google.gson.*
import org.threeten.bp.LocalDate
import java.lang.reflect.Type


class LocalDateTypeAdapter : JsonSerializer<LocalDate?>, JsonDeserializer<LocalDate?> {
    override fun serialize(src: LocalDate?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (src == null) return null
        return JsonPrimitive(src.toString())
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): LocalDate? {
        val jsonPrimitive = json?.asJsonPrimitive ?: return null
        try {
            if (jsonPrimitive.isString) {
                return LocalDate.parse(jsonPrimitive.asString)
            }

        } catch (e: RuntimeException) {
            throw JsonParseException("Unable to parse LocalDate", e)
        }

        throw JsonParseException("Unable to parse LocalDate")
    }
}