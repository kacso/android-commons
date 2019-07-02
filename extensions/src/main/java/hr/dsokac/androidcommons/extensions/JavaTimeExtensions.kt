package hr.dsokac.androidcommons.extensions

import org.threeten.bp.*

/**
 *
 * Extension class for java time classes
 *
 * @author Danijel Sokač
 */


/**
 * Converts [Instant] to [LocalDate] using [zoneId]
 *
 * @param zoneId ID of time zone for which [LocalDate] should be generated. Default is [ZoneId.systemDefault]
 *
 * @return [LocalDate] representing this [Instant]
 */
fun Instant.toLocalDate(zoneId: ZoneId = ZoneId.systemDefault()) = atZone(zoneId).toLocalDate()

/**
 * Converts [Instant] to [LocalDateTime] using [zoneId]
 *
 * @param zoneId ID of time zone for which [LocalDateTime] should be generated. Default is [ZoneId.systemDefault]
 *
 * @return [LocalDateTime] representing this [Instant]
 */
fun Instant.toLocalDateTime(zoneId: ZoneId = ZoneId.systemDefault()) = atZone(zoneId).toLocalDateTime()

/**
 * Converts [Instant] to [LocalTime] using [zoneId]
 *
 * @param zoneId ID of time zone for which [LocalTime] should be generated. Default is [ZoneId.systemDefault]
 *
 * @return [LocalTime] representing this [Instant]
 */
fun Instant.toLocalTime(zoneId: ZoneId = ZoneId.systemDefault()) = atZone(zoneId).toLocalTime()

/**
 * Converts [LocalDate] to point to first day of a month
 *
 * @return [LocalDate] representing first day of a month
 */
fun LocalDate.atStartOfMonth(): LocalDate {
    val yearMonth = YearMonth.from(this)
    return yearMonth.atDay(1)
}

/**
 * Converts [LocalDate] to point to last day of a month
 *
 * @return [LocalDate] representing last day of a month
 */
fun LocalDate.atEndOfMonth(): LocalDate {
    val yearMonth = YearMonth.from(this)
    return yearMonth.atEndOfMonth()
}

/**
 * Converts [LocalDate] to point to end of a day
 *
 * @return [LocalDate] representing end of a day
 */
fun LocalDate.atEndOfDay(): LocalDateTime {
    return atTime(23, 59, 59)
}

/**
 * Converts [LocalDate] to [Instant] using [zoneId]
 *
 * @param zoneId ID of time zone for which [Instant] should be generated. Default is [ZoneId.systemDefault]
 *
 * @return [Instant] representing this [LocalDate]
 */
fun LocalDate.toInstant(zoneId: ZoneId = ZoneId.systemDefault()): Instant {
    return atStartOfDay().toInstant(zoneId)
}

/**
 * Converts [LocalDateTime] to [Instant] using [zoneId]
 *
 * @param zoneId ID of time zone for which [Instant] should be generated. Default is [ZoneId.systemDefault]
 *
 * @return [Instant] representing this [LocalDateTime]
 */
fun LocalDateTime.toInstant(zoneId: ZoneId = ZoneId.systemDefault()): Instant {
    return Instant.from(atZone(zoneId))
}

/**
 * Converts [LocalDate] to [ZonedDateTime] using [zoneId]
 *
 * @param zoneId ID of time zone for which [ZonedDateTime] should be generated. Default is [ZoneId.systemDefault]
 *
 * @return [ZonedDateTime] representing this [LocalDate]
 */
fun LocalDate.toZonedDateTime(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime {
    return atStartOfDay(zoneId)
}