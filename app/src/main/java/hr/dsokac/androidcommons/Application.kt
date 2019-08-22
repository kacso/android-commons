package hr.dsokac.androidcommons

import hr.dsokac.androidcommons.core.BaseApplication
import hr.dsokac.androidcommons.db.AppDatabase
import hr.dsokac.androidcommons.logger.LOGGER
import hr.dsokac.androidcommons.logger.Logger
import hr.dsokac.androidcommons.ui.activities.LoginActivity

//TODO Dependency Injection
class Application : BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        LOGGER = Logger(BuildConfig.DEBUG)
    }

    override fun startLogin() {
        AppDatabase.resetInstance()
        startActivity(LoginActivity.getIntent(this))
    }

}