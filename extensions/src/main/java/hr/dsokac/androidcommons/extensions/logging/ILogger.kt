package hr.dsokac.androidcommons.extensions.logging

import android.util.Log

/**
 * Interface defining basic functionalities that each logger needs to implement in order to properly log messages.
 * Instance of implementation of this interface are used in Logging extensions.
 *
 * @author Danijel Sokač
 */
interface ILogger {
    /**
     * Logs [message] with log level set to [logLevel] and tag set to [tag]
     *
     * @param logLevel priority constant for the println method. Default value is [Log.DEBUG]
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param message The message you would like logged.
     */
    fun log(logLevel: Int = Log.DEBUG, tag: String = "", message: String)

    /**
     * Logs [Throwable]
     */
    fun log(throwable: Throwable)
}