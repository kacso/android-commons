package com.github.kacso.androidcommons.serialization.typeadapters

import com.github.kacso.androidcommons.serialization.extensions.registerJavaTimeTypeAdapters
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

class LocalDateTimeTypeAdapterTest {

    private val gson: Gson = GsonBuilder().registerJavaTimeTypeAdapters().create()

    @Test
    fun successfulSerialization() {
        val expected = LocalDateTime.now(ZoneId.of("UTC"))

        val serialized = gson.toJson(expected)

        Assertions.assertEquals("\"$expected\"", serialized)

        val deserialized = gson.fromJson(serialized, LocalDateTime::class.java)

        Assertions.assertEquals(expected, deserialized)
    }

    @Test
    fun deserializationFails() {
        Assertions.assertThrows(JsonParseException::class.java) {
            gson.fromJson(
                "WRONG_FORMAT",
                LocalDateTime::class.java
            )
        }
    }
}