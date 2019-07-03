package hr.dsokac.androidcommons.core.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import hr.dsokac.androidcommons.core.BaseApplication
import hr.dsokac.androidcommons.core.activities.BaseActivity
import hr.dsokac.androidcommons.core.views.BaseView
import hr.dsokac.androidcommons.permissions.manager.FragmentPermissionManager
import hr.dsokac.androidcommons.permissions.manager.IPermissionManager
import java.lang.ref.WeakReference

/**
 * Abstract [DialogFragment] class which implements common functions from [BaseView] and also solves most
 * common tasks in Dialog.
 *
 * It is advisable that all dialogs in project extend this class.
 */
abstract class BaseDialog : DialogFragment(), BaseView {
    protected open val progressDialog: AbstractProgressDialog by lazy {
        ProgressDialog.newInstance()
    }

    open val permissionManager: IPermissionManager by lazy {
        FragmentPermissionManager(WeakReference(this))
    }

    /**
     * Root view of the dialog. Use it to access other views inside layout
     */
    @Suppress("MemberVisibilityCanBePrivate")
    protected lateinit var rootView: View

    /**
     * This method is being used in order to inflate view for dialog
     *
     * @return reference to layout resource of current activity
     */
    @LayoutRes
    abstract fun getLayout(): Int

    /**
     * This method is called in order to set user defined theme to dialog
     * Override it in case that you don't want to set any theme, or would like to set
     * theme different then defined in [BaseApplication.getDialogTheme]
     */
    open fun applyStyle() {
        activity?.application?.let {
            if (it is BaseApplication) {
                it.getDialogTheme()?.apply {
                    setStyle(STYLE_NO_TITLE, this)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applyStyle()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getLayout(), container, false)
        return rootView
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionManager.onPermissionResult(requestCode, permissions, grantResults)
    }

    override fun showProgress() {
        activity?.apply {
            if (!progressDialog.isShown()) {
                progressDialog.show(this.supportFragmentManager, "ProgressDialog")
            }
        }
    }

    override fun hideProgress() {
        if (progressDialog.isShown()) {
            progressDialog.dismissAllowingStateLoss()
        }
    }

    /**
     * By default, it will just call [showError] function with extracted [error] resources
     */
    override fun showError(error: Int) {
        showError(getString(error))
    }

    /**
     * By default, it will display [error] in [Toast] with duration set to [Toast.LENGTH_LONG]
     */
    override fun showError(error: String) {
        context?.apply {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * By default, it will just call [showMessage] function with extracted [msg] resources
     */
    override fun showMessage(msg: Int) {
        showMessage(getString(msg))
    }

    /**
     * By default, it will display [msg] in [Toast] with duration set to [Toast.LENGTH_LONG]
     */
    override fun showMessage(msg: String) {
        context?.apply {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }

    override fun redirectToLogin(forceRedirect: Boolean) {
        BaseActivity.currentView?.redirectToLogin(forceRedirect)
    }

    override fun getViewContext(): Context? = context

    override fun backPressed() {
        dismissAllowingStateLoss()
    }
}