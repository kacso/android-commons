package hr.dsokac.androidcommons.serialization.typeadapters

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import hr.dsokac.androidcommons.serialization.extensions.registerJavaTimeTypeAdapters
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.threeten.bp.Instant

class InstantTypeAdapterTest {

    private val gson: Gson = GsonBuilder().registerJavaTimeTypeAdapters().create()

    @Test
    fun successfulSerialization() {
        val expected = Instant.now()

        val serialized = gson.toJson(expected)

        Assertions.assertEquals("\"$expected\"", serialized)

        val deserialized = gson.fromJson(serialized, Instant::class.java)

        Assertions.assertEquals(expected, deserialized)
    }

    @Test
    fun deserializationFails() {
        Assertions.assertThrows(JsonParseException::class.java) { gson.fromJson("WRONG_FORMAT", Instant::class.java) }
    }
}