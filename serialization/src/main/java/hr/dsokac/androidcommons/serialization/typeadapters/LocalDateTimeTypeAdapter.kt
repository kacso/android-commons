package hr.dsokac.androidcommons.serialization.typeadapters

import com.google.gson.*
import org.threeten.bp.LocalDateTime
import java.lang.reflect.Type

class LocalDateTimeTypeAdapter : JsonSerializer<LocalDateTime?>, JsonDeserializer<LocalDateTime?> {
    override fun serialize(src: LocalDateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (src == null) return null
        return JsonPrimitive(src.toString())
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): LocalDateTime? {
        val jsonPrimitive = json?.asJsonPrimitive ?: return null
        try {
            if (jsonPrimitive.isString) {
                return LocalDateTime.parse(jsonPrimitive.asString)
            }

        } catch (e: RuntimeException) {
            throw JsonParseException("Unable to parse LocalDateTime", e)
        }

        throw JsonParseException("Unable to parse LocalDateTime")
    }
}

