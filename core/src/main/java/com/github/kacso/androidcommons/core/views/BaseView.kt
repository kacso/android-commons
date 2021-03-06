package com.github.kacso.androidcommons.core.views

import android.content.Context
import com.github.kacso.androidcommons.data.ErrorHolder
import com.github.kacso.androidcommons.data.MessageHolder

/**
 * Interface which defines basic functionalities that each view should implement
 *
 * @author Danijel Sokač
 */
interface BaseView {
    /**
     * Display progress for long running tasks
     */
    fun showProgress()

    /**
     * Hide progress of long running task
     */
    fun hideProgress()

    /**
     * Display error message to the user
     *
     * @param error     [ErrorHolder] which contains info about error
     */
    fun onError(error: ErrorHolder)

    /**
     * Display any message to the user
     *
     * @param msg     [MessageHolder] which contains info about error
     */
    fun showMessage(msg: MessageHolder)

    /**
     * Redirect user to login.
     * Should be used in case of long inactivity or when token/session has expired
     *
     * @param forceRedirect enforce redirect to login without showing message to user.
     *                      Useful for logout functionality
     */
    fun redirectToLogin(forceRedirect: Boolean = false)

    /**
     *
     * @return  Context of this view, null if context is not available/valid
     */
    fun getViewContext(): Context?

    /**
     * Should be called when user presses back button
     */
    fun backPressed()
}