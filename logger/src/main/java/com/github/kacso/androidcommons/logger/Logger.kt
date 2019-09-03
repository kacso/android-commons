package com.github.kacso.androidcommons.logger

import android.util.Log

/**
 * Default implementation of [ILogger].
 * It will log messages in logcat in case that app is in debug mode ([isDebug] is set to true)
 *
 * @property isDebug is debug mode enabled
 *
 * @author Danijel Sokač
 */
open class Logger(private val isDebug: Boolean) : ILogger {
    override fun log(logLevel: Int, tag: String, message: String) {
        runCatching {
            if (isDebug) {
                when (logLevel) {
                    Log.VERBOSE -> Log.v(tag, message)
                    Log.DEBUG -> Log.d(tag, message)
                    Log.INFO -> Log.i(tag, message)
                    Log.WARN -> Log.w(tag, message)
                    Log.ERROR -> Log.e(tag, message)
                    Log.ASSERT -> Log.wtf(tag, message)
                }
            }
        }.onFailure {
            log(it)
        }
    }

    override fun log(throwable: Throwable) {
        runCatching {
            if (isDebug) {
                Log.e(throwable.javaClass.name, throwable.message ?: "Empty message")
            }
        }
    }
}