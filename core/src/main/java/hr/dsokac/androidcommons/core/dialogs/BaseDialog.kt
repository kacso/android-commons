package hr.dsokac.androidcommons.core.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import hr.dsokac.androidcommons.core.BaseApplication
import hr.dsokac.androidcommons.core.activities.BaseActivity
import hr.dsokac.androidcommons.core.models.ErrorHolder
import hr.dsokac.androidcommons.core.models.MessageHolder
import hr.dsokac.androidcommons.core.mvvm.viewmodels.IBaseViewModel
import hr.dsokac.androidcommons.core.views.BaseView
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.permissions.manager.FragmentPermissionManager
import hr.dsokac.androidcommons.permissions.manager.IPermissionManager
import java.lang.ref.WeakReference

/**
 * Abstract [DialogFragment] class which implements common functions from [BaseView] and also solves most
 * common tasks in Dialog.
 *
 * It is advisable that all dialogs in project extend this class.
 *
 * In case that you are implementing this class, make sure to implement [IBaseViewModel] within your dialog.
 *
 * @author Danijel Sokač
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
     * View model associated with this dialog
     */
    protected open val viewModel: IBaseViewModel? = null

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
        initViewModelListeners()
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
     * By default, it will display [error] in [Toast] with duration set to [Toast.LENGTH_LONG]
     */
    override fun onError(error: ErrorHolder) {
        context?.apply {
            if (!isVisible) return@apply
            if (error.cause is Unauthorized) {
                redirectToLogin()
            } else {
                Toast.makeText(this, error.toString(this), Toast.LENGTH_LONG).show()
            }
        }
    }

    /**
     * By default, it will display [msg] in [Toast] with duration set to [Toast.LENGTH_LONG]
     */
    override fun showMessage(msg: MessageHolder) {
        context?.apply {
            if (!isVisible) return@apply
            Toast.makeText(this, msg.toString(this), Toast.LENGTH_LONG).show()
        }
    }

    override fun redirectToLogin(forceRedirect: Boolean) {
        BaseActivity.currentView?.redirectToLogin(forceRedirect)
    }

    override fun getViewContext(): Context? = context

    override fun backPressed() {
        dismissAllowingStateLoss()
    }

    /**
     * Function which will start observing [LiveData] objects from [IBaseViewModel]
     */
    protected open fun initViewModelListeners() {
        viewModel?.apply {
            getError().observe(this@BaseDialog, Observer {
                onError(it)
            })
            getMessage().observe(this@BaseDialog, Observer {
                showMessage(it)
            })
            getIsProgressActive().observe(this@BaseDialog, Observer {
                if (it) {
                    showProgress()
                } else {
                    hideProgress()
                }
            })
        }
    }
}