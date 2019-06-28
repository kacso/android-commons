package hr.dsokac.androidcommons.extensions.logging

import android.util.Log

interface ILogger {
    fun log(logLevel: Int = Log.DEBUG, tag: String = "", message: String)

    fun log(throwable: Throwable)
}