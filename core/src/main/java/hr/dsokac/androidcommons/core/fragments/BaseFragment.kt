package hr.dsokac.androidcommons.core.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.google.android.material.snackbar.Snackbar
import hr.dsokac.androidcommons.core.SNACKBAR_ELEVATION
import hr.dsokac.androidcommons.core.activities.BaseActivity
import hr.dsokac.androidcommons.core.dialogs.AbstractProgressDialog
import hr.dsokac.androidcommons.core.dialogs.ProgressDialog
import hr.dsokac.androidcommons.core.models.ErrorHolder
import hr.dsokac.androidcommons.core.models.MessageHolder
import hr.dsokac.androidcommons.core.mvvm.viewmodels.IBaseViewModel
import hr.dsokac.androidcommons.core.views.BaseView
import hr.dsokac.androidcommons.extensions.goBack
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.permissions.manager.FragmentPermissionManager
import hr.dsokac.androidcommons.permissions.manager.IPermissionManager
import java.lang.ref.WeakReference

/**
 * Abstract [Fragment] class which implements common functionalities from [BaseView] and solves
 * most common tasks in Fragment.
 *
 * It is advisable that all fragments in project extend this class.
 *
 * In case that you are implementing this class, make sure to implement [IBaseViewModel] within your fragment.
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
     * View model associated with this fragment
     */
    protected abstract val viewModel: IBaseViewModel

    /**
     * This method is being used in order to inflate view for fragment
     *
     * @return reference to layout resource of current activity
     */
    @LayoutRes
    protected abstract fun getLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
     * By default, it will display [error] in [Snackbar] with duration set to [Snackbar.LENGTH_LONG]
     */
    override fun onError(error: ErrorHolder) {
        context?.apply {
            if (!isVisible) return@apply
            if (error.cause is Unauthorized) {
                redirectToLogin()
            } else {
                val snackbar = Snackbar.make(rootView, error.toString(this), Snackbar.LENGTH_LONG)
                snackbar.view.elevation = SNACKBAR_ELEVATION
                snackbar.show()
            }
        }
    }

    /**
     * By default, it will display [msg] in [Snackbar] with duration set to [Snackbar.LENGTH_LONG]
     */
    override fun showMessage(msg: MessageHolder) {
        context?.apply {
            if (!isVisible) return@apply
            val snackbar = Snackbar.make(rootView, msg.toString(this), Snackbar.LENGTH_LONG)
            snackbar.view.elevation = SNACKBAR_ELEVATION
            snackbar.show()

        }
    }

    override fun redirectToLogin(forceRedirect: Boolean) {
        BaseActivity.currentView?.redirectToLogin(forceRedirect)
    }

    override fun getViewContext(): Context? = context

    override fun backPressed() {
        activity?.goBack()
    }

    /**
     * Function which will start observing [LiveData] objects from [IBaseViewModel]
     */
    protected open fun initViewModelListeners() {
        viewModel.getError().observe(this, ::onError)
        viewModel.getMessage().observe(this, ::showMessage)
        viewModel.getIsProgressActive().observe(this) {
            if (it) {
                showProgress()
            } else {
                hideProgress()
            }
        }
    }
}