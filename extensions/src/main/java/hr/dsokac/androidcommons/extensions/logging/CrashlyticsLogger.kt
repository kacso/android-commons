package hr.dsokac.androidcommons.extensions.logging

import com.crashlytics.android.Crashlytics

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