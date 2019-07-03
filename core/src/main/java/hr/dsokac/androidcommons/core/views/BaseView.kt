package hr.dsokac.androidcommons.core.views

import android.content.Context
import androidx.annotation.StringRes

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
     * @param error     reference to string resources of error message
     */
    fun showError(@StringRes error: Int)

    /**
     * Display error message to the user
     *
     * @param error     string to be shown as error
     */
    fun showError(error: String)

    /**
     * Display any message to the user
     *
     * @param msg     string resources of message to be displayed
     */
    fun showMessage(@StringRes msg: Int)

    /**
     * Display any message to the user
     *
     * @param msg     string to be displayed
     */
    fun showMessage(msg: String)

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