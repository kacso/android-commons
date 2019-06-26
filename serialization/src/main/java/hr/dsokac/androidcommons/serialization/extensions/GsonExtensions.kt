package hr.dsokac.androidcommons.serialization.extensions

import com.google.gson.GsonBuilder
import hr.dsokac.androidcommons.serialization.typeadapters.*
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