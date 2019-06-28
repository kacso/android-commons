package hr.dsokac.androidcommons.extensions.logging

import android.util.Log

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
            Log.e(throwable.javaClass.name, throwable.message ?: "Empty message")
        }
    }
}