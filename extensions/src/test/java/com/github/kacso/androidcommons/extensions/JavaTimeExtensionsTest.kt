package com.github.kacso.androidcommons.extensions

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.threeten.bp.*

class JavaTimeExtensionsTest {

    @BeforeEach
    fun setup() {
        mockkStatic(ZoneId::class)
        every { ZoneId.systemDefault() } returns ZoneId.of("UTC")
    }

    @Test
    fun instantToLocalDate() {
        val instant = Instant.parse("2019-07-02T23:01:30Z")

        Assertions.assertEquals(
            LocalDate.parse("2019-07-02"),
            instant.toLocalDate()
        )
        Assertions.assertEquals(
            LocalDate.parse("2019-07-03"),
            instant.toLocalDate(ZoneId.of("UTC+1"))
        )
    }

    @Test
    fun instantToLocalDateTime() {
        val instant = Instant.parse("2019-07-02T23:01:30Z")

        Assertions.assertEquals(
            LocalDateTime.parse("2019-07-02T23:01:30"),
            instant.toLocalDateTime()
        )
        Assertions.assertEquals(
            LocalDateTime.parse("2019-07-03T00:01:30"),
            instant.toLocalDateTime(ZoneId.of("UTC+1"))
        )
    }

    @Test
    fun instantToLocalTime() {
        val instant = Instant.parse("2019-07-02T23:01:30Z")

        Assertions.assertEquals(
            LocalTime.parse("23:01:30"),
            instant.toLocalTime()
        )
        Assertions.assertEquals(
            LocalTime.parse("00:01:30"),
            instant.toLocalTime(ZoneId.of("UTC+1"))
        )
    }

    @Test
    fun atStartOfMonth() {
        Assertions.assertEquals(
            LocalDate.parse("2019-07-01"),
            LocalDate.parse("2019-07-02").atStartOfMonth()
        )
        Assertions.assertEquals(
            LocalDate.parse("2019-07-01"),
            LocalDate.parse("2019-07-01").atStartOfMonth()
        )
    }

    @Test
    fun atEndOfMonth() {
        Assertions.assertEquals(
            LocalDate.parse("2019-07-31"),
            LocalDate.parse("2019-07-02").atEndOfMonth()
        )
        Assertions.assertEquals(
            LocalDate.parse("2019-06-30"),
            LocalDate.parse("2019-06-01").atEndOfMonth()
        )
        Assertions.assertEquals(
            LocalDate.parse("2019-02-28"),
            LocalDate.parse("2019-02-01").atEndOfMonth()
        )
        Assertions.assertEquals(
            LocalDate.parse("2020-02-29"),
            LocalDate.parse("2020-02-01").atEndOfMonth()
        )
    }

    @Test
    fun atEndOfDay() {
        Assertions.assertEquals(
            LocalDateTime.parse("2019-07-02T23:59:59"),
            LocalDate.parse("2019-07-02").atEndOfDay()
        )
    }

    @Test
    fun localDateToInstant() {
        val localDate = LocalDate.parse("2019-07-02")

        Assertions.assertEquals(
            Instant.parse("2019-07-02T00:00:00Z"),
            localDate.toInstant()
        )
        Assertions.assertEquals(
            Instant.parse("2019-07-01T23:00:00Z"),
            localDate.toInstant(ZoneId.of("UTC+1"))
        )
    }

    @Test
    fun localDateTimeToInstant() {
        val localDateTime = LocalDateTime.parse("2019-07-02T00:10:30")

        Assertions.assertEquals(
            Instant.parse("2019-07-02T00:10:30Z"),
            localDateTime.toInstant()
        )
        Assertions.assertEquals(
            Instant.parse("2019-07-01T23:10:30Z"),
            localDateTime.toInstant(ZoneId.of("UTC+1"))
        )
    }

    @Test
    fun localDateToZonedDateTime() {
        val localDate = LocalDate.parse("2019-07-02")

        Assertions.assertEquals(
            ZonedDateTime.parse("2019-07-02T00:00:00Z[UTC]"),
            localDate.toZonedDateTime()
        )
        Assertions.assertEquals(
            ZonedDateTime.parse("2019-07-02T00:00:00+01:00[UTC+01:00]"),
            localDate.toZonedDateTime(ZoneId.of("UTC+1"))
        )
    }
}