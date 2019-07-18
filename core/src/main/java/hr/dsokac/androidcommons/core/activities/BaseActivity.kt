package hr.dsokac.androidcommons.core.activities

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import hr.dsokac.androidcommons.core.BaseApplication
import hr.dsokac.androidcommons.core.R
import hr.dsokac.androidcommons.core.SNACKBAR_ELEVATION
import hr.dsokac.androidcommons.core.dialogs.AbstractProgressDialog
import hr.dsokac.androidcommons.core.dialogs.DialogMessage
import hr.dsokac.androidcommons.core.dialogs.ProgressDialog
import hr.dsokac.androidcommons.core.models.ErrorHolder
import hr.dsokac.androidcommons.core.models.MessageHolder
import hr.dsokac.androidcommons.core.mvvm.viewmodels.IBaseViewModel
import hr.dsokac.androidcommons.core.views.BaseView
import hr.dsokac.androidcommons.extensions.getSystemLocale
import hr.dsokac.androidcommons.extensions.goBack
import hr.dsokac.androidcommons.extensions.toUserDefinedLocaleContext
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.permissions.manager.ActivityPermissionManager
import hr.dsokac.androidcommons.permissions.manager.IPermissionManager
import java.lang.ref.WeakReference
import java.util.*

/**
 * Abstract [AppCompatActivity] class which implements common functionalities from [BaseView] and solves
 * most common tasks in Activity.
 *
 * It is advisable that all activities in project extend this class.
 *
 * In case that you are implementing this class, make sure to implement [IBaseViewModel] within your activity.
 *
 * @author Danijel Sokač
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {
    companion object {
        /**
         * Instance of currently visible [BaseActivity]
         */
        var currentView: BaseActivity? = null
    }

    /**
     * View model associated with this activity
     */
    protected abstract val viewModel: IBaseViewModel

    protected open val progressDialog: AbstractProgressDialog by lazy {
        ProgressDialog.newInstance()
    }

    protected open val permissionManager: IPermissionManager by lazy {
        ActivityPermissionManager(WeakReference(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getAlternativeThemeRes()?.apply {
            setTheme(this)
        }
        super.onCreate(savedInstanceState)
        currentView = this
        setContentView(layoutRes)

        initViewModelListeners()
    }

    override fun onResume() {
        super.onResume()
        currentView = this
    }

    /**
     * By default, call [backPressed]
     */
    override fun onBackPressed() {
        backPressed()
    }

    /**
     * By default, call [backPressed]
     */
    override fun onSupportNavigateUp(): Boolean {
        backPressed()
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionManager.onPermissionResult(requestCode, permissions, grantResults)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase.toUserDefinedLocaleContext(getUserLocale(newBase)))
    }

    /**
     * Returns locale defined by user in settings, if such option does not exist, return device default locale.
     *
     * Default behaviour, returns locale from [BaseApplication.getUserLocale] or default locale if [BaseApplication]
     * could not be retrieved
     */
    open fun getUserLocale(context: Context): Locale {
        val app = application
        if (app is BaseApplication) {
            return app.getUserLocale()
        }
        return getSystemLocale()
    }

    /**
     * This method is called in order to assign user defined themes to activity.
     * By default, this method will return theme defined in [BaseApplication.getAppTheme].
     *
     * @return [StyleRes] representing theme to be used in activity, or null if default theme should be used
     */
    @StyleRes
    open fun getAlternativeThemeRes(): Int? {
        val app = application
        if (app is BaseApplication) {
            return app.getAppTheme()
        }
        return null
    }

    /**
     * Reference to layout resource of current activity.
     *
     * This value is being used in order to set content view for current activity
     *
     */
    @get:LayoutRes
    protected abstract val layoutRes: Int

    /**
     * Gets root view of current activity.
     * This view is being used to display default messages and progress.
     *
     * @return root view of activity
     */
    protected abstract fun getContentHolder(): View

    override fun showProgress() {
        if (!progressDialog.isShown()) {
            progressDialog.show(supportFragmentManager, "ProgressDialog")
        }
    }

    override fun hideProgress() {
        if (progressDialog.isShown()) {
            progressDialog.dismissAllowingStateLoss()
        }
    }

    /**
     * By default, it will display [error] in [Snackbar] with duration set to [Snackbar.LENGTH_LONG]
     */
    override fun onError(error: ErrorHolder) {
        if (!isActive()) return
        if (error.cause is Unauthorized) {
            redirectToLogin()
        } else {
            val snackbar = Snackbar.make(getContentHolder(), error.toString(this), Snackbar.LENGTH_LONG)
            snackbar.view.elevation = SNACKBAR_ELEVATION
            snackbar.show()
        }
    }

    /**
     * By default, it will display [msg] in [Snackbar] with duration set to [Snackbar.LENGTH_LONG]
     */
    override fun showMessage(msg: MessageHolder) {
        if (!isActive()) return
        val snackbar = Snackbar.make(getContentHolder(), msg.toString(this), Snackbar.LENGTH_LONG)
        snackbar.view.elevation = SNACKBAR_ELEVATION
        snackbar.show()

    }

    override fun redirectToLogin(forceRedirect: Boolean) {
        if (!forceRedirect) {
            DialogMessage.newInstance(
                title = getString(R.string.dialog_title_session_expired),
                message = getString(R.string.dialog_msg_session_expired),
                positiveLbl = getString(R.string.dialog_confirm_session_expired),
                dismissible = false,
                positiveAction = ::startLogin
            ).show(supportFragmentManager, "SessionExpiredDialog")
        } else {
            startLogin()
        }
    }

    override fun getViewContext(): Context? {
        return this
    }

    /**
     * By default it will call extension function [goBack]
     */
    override fun backPressed() {
        goBack()
    }

    open fun isActive(): Boolean = !isFinishing && !isDestroyed

    private fun startLogin() {
        val app = application
        if (app is BaseApplication) {
            app.startLogin()
            finish()
        } else {
            throw IllegalAccessException("Application is not extending BaseApplication. Make sure that you added proper application into manifest or override redirectToLogin function")
        }
    }

    /**
     * Function which will start observing [LiveData] objects from [IBaseViewModel]
     */
    protected open fun initViewModelListeners() {
        viewModel.getError().observe(this, Observer {
            onError(it)
        })
        viewModel.getMessage().observe(this, Observer {
            showMessage(it)
        })
        viewModel.getIsProgressActive().observe(this, Observer {
            if (it) {
                showProgress()
            } else {
                hideProgress()
            }
        })
    }
}