package com.github.kacso.androidcommons.logger

import android.util.Log

/**
 * Instance of [ILogger] to be used with log extension functions
 * Set it in application onCreate method in order to be able to use logging extensions in whole app
 *
 * @author Danijel Sokač
 */
var LOGGER: ILogger? = null

/**
 * Logs [Throwable] using [LOGGER] instance
 */
fun Throwable.log() {
    LOGGER?.log(this)
}

/**
 * Logs [message] with logLevel set to [Log.DEBUG] and tag set to [tag] using [LOGGER] instance
 *
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param message The message you would like logged.
 */
fun log(tag: String, message: String) {
    log(Log.DEBUG, tag, message)
}

/**
 * Logs [message] logLevel set to [Log.DEBUG] and without tag using [LOGGER] instance
 *
 * @param message The message you would like logged.
 */
fun log(message: String) {
    log(Log.DEBUG, "LOGGER", message)
}

/**
 * Logs [message] with log level set to [logLevel] and tag set to [tag] using [LOGGER] instance
 *
 * @param logLevel priority constant for the println method. Default value is [Log.DEBUG]
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param message The message you would like logged.
 */
fun log(logLevel: Int = Log.DEBUG, tag: String = "LOGGER", message: String) {
    LOGGER?.log(logLevel, tag, message)
}