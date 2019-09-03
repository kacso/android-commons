package com.github.kacso.androidcommons.serialization.extensions

import com.github.kacso.androidcommons.serialization.typeadapters.*
import com.google.gson.GsonBuilder
import org.threeten.bp.*

fun GsonBuilder.registerJavaTimeTypeAdapters(): GsonBuilder {
    registerTypeAdapter(Duration::class.java, DurationTypeAdapter())
    registerTypeAdapter(Instant::class.java, InstantTypeAdapter())
    registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter())
    registerTypeAdapter(LocalDate::class.java, LocalDateTypeAdapter())
    registerTypeAdapter(LocalTime::class.java, LocalTimeTypeAdapter())
    registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeTypeAdapter())

    return this
}