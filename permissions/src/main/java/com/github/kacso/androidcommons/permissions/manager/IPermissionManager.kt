package com.github.kacso.androidcommons.permissions.manager

import com.github.kacso.androidcommons.permissions.callbacks.PermissionCallback

/**
 * Interface which defines basic functionality for managing user permissions
 *
 * @author Danijel Sokač
 */
interface IPermissionManager {
    /**
     * Method to be called when permission check needs to be performed
     *
     * @param permissions   Array of required permissions to perform some task
     * @param callback      Callback on which result will be returned
     *
     * @return ID of permission check request
     */
    fun requirePermissions(permissions: Array<String>, callback: PermissionCallback): Int

    /**
     * Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult)
     * when permission result are received.
     * This method will send results to the actual caller.
     *
     */
    fun onPermissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
}