package com.github.kacso.androidcommons.serialization.typeadapters

import com.google.gson.*
import org.threeten.bp.Duration
import java.lang.reflect.Type


class DurationTypeAdapter : JsonSerializer<Duration?>, JsonDeserializer<Duration?> {
    override fun serialize(src: Duration?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (src == null) return null
        return JsonPrimitive(src.toString())
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Duration? {
        val jsonPrimitive = json?.asJsonPrimitive ?: return null
        try {
            if (jsonPrimitive.isString) {
                return Duration.parse(jsonPrimitive.asString)
            }

        } catch (e: RuntimeException) {
            throw JsonParseException("Unable to parse Duration", e)
        }

        throw JsonParseException("Unable to parse Duration")
    }
}