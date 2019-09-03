package com.github.kacso.androidcommons.logger

import com.crashlytics.android.Crashlytics

/**
 * [CrashlyticsLogger] extends [Logger] implementation by additionally to logcat logging all messages to
 * [Crashlytics] instance.
 *
 * In order to use this logger, enable [Crashlytics] for your app.
 *
 * @author Danijel Sokač
 */
class CrashlyticsLogger(isDebug: Boolean) : Logger(isDebug) {
    override fun log(logLevel: Int, tag: String, message: String) {
        runCatching {
            super.log(logLevel, tag, message)

            if (isCrashlyticsInitialized()) {
                Crashlytics.log(message)
            }
        }
    }

    override fun log(throwable: Throwable) {
        runCatching {
            super.log(throwable)

            if (isCrashlyticsInitialized()) {
                Crashlytics.logException(throwable)
            }
        }

    }

    private fun isCrashlyticsInitialized(): Boolean = Crashlytics.getInstance() != null


}