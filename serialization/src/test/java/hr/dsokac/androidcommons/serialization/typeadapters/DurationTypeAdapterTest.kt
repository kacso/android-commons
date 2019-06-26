package hr.dsokac.androidcommons.serialization.typeadapters

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import hr.dsokac.androidcommons.serialization.extensions.registerJavaTimeTypeAdapters
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.threeten.bp.Duration

class DurationTypeAdapterTest {

    private val gson: Gson = GsonBuilder().registerJavaTimeTypeAdapters().create()

    @Test
    fun successfulSerialization() {
        val expected = Duration.ofSeconds(259000)

        val serialized = gson.toJson(expected)

        Assertions.assertEquals("\"$expected\"", serialized)

        val deserialized = gson.fromJson(serialized, Duration::class.java)

        Assertions.assertEquals(expected, deserialized)
    }

    @Test
    fun deserializationFails() {
        Assertions.assertThrows(JsonParseException::class.java) { gson.fromJson("WRONG_FORMAT", Duration::class.java) }
    }
}