package com.github.kacso.androidcommons.permissions

import android.Manifest

/**
 * File which contains basic arrays of permissions.
 * Make sure to add this permissions to you manifest also, not only use it in [IPermissionManager]
 *
 * @author Danijel Sokač
 */

/**
 * Permissions required to access user location
 */
val LOCATION_PERMISSIONS = arrayOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION
)

/**
 * Permissions required to get full camera experience
 */
val FULL_CAMERA_PERMISSIONS = arrayOf(
    Manifest.permission.CAMERA,
    Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE
)

/**
 * Permissions required to access camera only
 */
val CAMERA_PERMISSIONS = arrayOf(
    Manifest.permission.CAMERA
)

/**
 * Permissions required to gain full storage access (read and write)
 */
val STORAGE_PERMISSIONS = arrayOf(
    Manifest.permission.WRITE_EXTERNAL_STORAGE,
    Manifest.permission.READ_EXTERNAL_STORAGE
)

/**
 * Permissions required to gain read only storage access
 */
val READ_ONLY_STORAGE_PERMISSIONS = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

/**
 * Permissions required to be able to initiate phone call
 */
val CALL_PHONE_PERMISSIONS = arrayOf(Manifest.permission.CALL_PHONE)