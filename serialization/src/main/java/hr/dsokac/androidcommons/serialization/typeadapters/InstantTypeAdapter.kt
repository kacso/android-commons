package hr.dsokac.androidcommons.serialization.typeadapters

import com.google.gson.*
import org.threeten.bp.Instant
import java.lang.reflect.Type


class InstantTypeAdapter : JsonSerializer<Instant?>, JsonDeserializer<Instant?> {
    override fun serialize(src: Instant?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (src == null) return null
        return JsonPrimitive(src.toString())
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Instant? {
        val jsonPrimitive = json?.asJsonPrimitive ?: return null
        try {
            if (jsonPrimitive.isString) {
                return Instant.parse(jsonPrimitive.asString)
            }

            // if provided as Long
            if (jsonPrimitive.isNumber) {
                return Instant.ofEpochMilli(jsonPrimitive.asLong)
            }

        } catch (e: RuntimeException) {
            throw JsonParseException("Unable to parse Instant", e)
        }

        throw JsonParseException("Unable to parse Instant")
    }
}