package hr.dsokac.androidcommons.extensions.logging

import android.util.Log

var LOGGER: ILogger? = null

fun Throwable.log() {
    LOGGER?.log(this)
}

fun log(tag: String, message: String) {
    log(Log.DEBUG, tag, message)
}

fun log(message: String) {
    log(Log.DEBUG, "", message)
}

fun log(logLevel: Int = Log.DEBUG, tag: String = "", message: String) {
    LOGGER?.log(logLevel, tag, message)
}