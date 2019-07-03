package hr.dsokac.androidcommons.core.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import hr.dsokac.androidcommons.core.SNACKBAR_ELEVATION
import hr.dsokac.androidcommons.core.activities.BaseActivity
import hr.dsokac.androidcommons.core.dialogs.AbstractProgressDialog
import hr.dsokac.androidcommons.core.dialogs.ProgressDialog
import hr.dsokac.androidcommons.core.views.BaseView
import hr.dsokac.androidcommons.extensions.goBack
import hr.dsokac.androidcommons.permissions.manager.FragmentPermissionManager
import hr.dsokac.androidcommons.permissions.manager.IPermissionManager
import java.lang.ref.WeakReference

/**
 * Abstract [Fragment] class which implements common functionalities from [BaseView] and solves
 * most common tasks in Fragment.
 *
 * It is advisable that all fragments in project extend this class.
 *
 * @author Danijel Sokač
 */
abstract class BaseFragment : Fragment(), BaseView {
    /**
     * Root view of fragment. Use it to access other views in layout.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    protected lateinit var rootView: View

    protected open val progressDialog: AbstractProgressDialog by lazy {
        ProgressDialog.newInstance()
    }

    open val permissionManager: IPermissionManager by lazy {
        FragmentPermissionManager(WeakReference(this))
    }

    /**
     * This method is being used in order to inflate view for fragment
     *
     * @return reference to layout resource of current activity
     */
    @LayoutRes
    abstract fun getLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
     * By default, it will display [error] in [Snackbar] with duration set to [Snackbar.LENGTH_LONG]
     */
    override fun showError(error: String) {
        context?.apply {
            if (isVisible) {
                val snackbar = Snackbar.make(rootView, error, Snackbar.LENGTH_LONG)
                snackbar.view.elevation = SNACKBAR_ELEVATION
                snackbar.show()
            }
        }
    }

    /**
     * By default, it will just call [showMessage] function with extracted [msg] resources
     */
    override fun showMessage(msg: Int) {
        showMessage(getString(msg))
    }

    /**
     * By default, it will display [msg] in [Snackbar] with duration set to [Snackbar.LENGTH_LONG]
     */
    override fun showMessage(msg: String) {
        context?.apply {
            if (isVisible) {
                val snackbar = Snackbar.make(rootView, msg, Snackbar.LENGTH_LONG)
                snackbar.view.elevation = SNACKBAR_ELEVATION
                snackbar.show()
            }
        }
    }

    override fun redirectToLogin(forceRedirect: Boolean) {
        BaseActivity.currentView?.redirectToLogin(forceRedirect)
    }

    override fun getViewContext(): Context? = context

    override fun backPressed() {
        activity?.goBack()
    }
}