package com.github.kacso.androidcommons.core.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.github.kacso.androidcommons.core.SNACKBAR_ELEVATION
import com.github.kacso.androidcommons.core.activities.BaseActivity
import com.github.kacso.androidcommons.core.dialogs.AbstractProgressDialog
import com.github.kacso.androidcommons.core.dialogs.ProgressDialog
import com.github.kacso.androidcommons.core.mvvm.viewmodels.IBaseViewModel
import com.github.kacso.androidcommons.core.views.BaseView
import com.github.kacso.androidcommons.data.ErrorHolder
import com.github.kacso.androidcommons.data.MessageHolder
import com.github.kacso.androidcommons.extensions.goBack
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.permissions.manager.FragmentPermissionManager
import com.github.kacso.androidcommons.permissions.manager.IPermissionManager
import com.google.android.material.snackbar.Snackbar
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
    protected abstract val viewModel: IBaseViewModel?

    /**
     * Reference to layout resource of current fragment.
     *
     * This method is being used in order to inflate view for fragment.
     */
    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater.inflate(layoutRes, container, false)
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
        viewModel?.getError()?.observe(this, Observer {
            onError(it)
        })
        viewModel?.getMessage()?.observe(this, Observer {
            showMessage(it)
        })
        viewModel?.getIsProgressActive()?.observe(this, Observer {
            if (it) {
                showProgress()
            } else {
                hideProgress()
            }
        })
    }
}