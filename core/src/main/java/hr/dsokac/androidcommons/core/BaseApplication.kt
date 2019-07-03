package hr.dsokac.androidcommons.core

import android.app.Application
import android.content.Context
import androidx.annotation.StyleRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.jakewharton.threetenabp.AndroidThreeTen
import hr.dsokac.androidcommons.extensions.getSystemLocale
import hr.dsokac.androidcommons.extensions.toUserDefinedLocaleContext
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Application class which defines and implements common functionalities needed on application level.
 * Some of functionalities in this library depends on this class, so make sure to use this in your app.
 *
 * @author Danijel Sokač
 */
abstract class BaseApplication : Application(), LifecycleObserver {
    companion object {
        /**
         * Context of the application
         */
        lateinit var appContext: Context
    }

    open var isAppForegrounded = AtomicBoolean(false)

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        //Setup application class as lifecycle observer. It is used to track if app is foregrounded or not
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

        //Initialize javatime lib
        AndroidThreeTen.init(this)
    }

    override fun attachBaseContext(base: Context) {
        appContext = base
        //Setup app locale to be used
        super.attachBaseContext(base.toUserDefinedLocaleContext(getUserLocale()))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onAppBackgrounded() {
        isAppForegrounded.set(false)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onAppForegrounded() {
        isAppForegrounded.set(true)
    }

    /**
     * Returns locale defined by user in settings, if such option does not exist, return device default locale.
     *
     * Default behaviour, returns device default locale
     */
    open fun getUserLocale(): Locale {
        return getSystemLocale()
    }

    /**
     * This function should start Login activity used within your app
     *
     */
    abstract fun startLogin()

    /**
     * This method returns theme which will be used across all activities.
     * In case that theme defined in AndroidManifest would like to be used, returned value
     * must be null (which is default value)
     *
     * @return [StyleRes] representing theme to be used or null if default should be used
     */
    @StyleRes
    open fun getAppTheme(): Int? = null

    /**
     * This method returns theme which will be used across all dialogs.
     * In case that theme defined in AndroidManifest would like to be used, returned value
     * must be null (which is default value)
     *
     * @return [StyleRes] representing theme to be used or null if default should be used
     */
    @StyleRes
    open fun getDialogTheme(): Int? = null
}