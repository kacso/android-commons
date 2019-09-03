package com.github.kacso.androidcommons

import com.github.kacso.androidcommons.core.BaseApplication
import com.github.kacso.androidcommons.db.AppDatabase
import com.github.kacso.androidcommons.logger.LOGGER
import com.github.kacso.androidcommons.logger.Logger
import com.github.kacso.androidcommons.ui.activities.LoginActivity

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