[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [IPermissionManager](index.md) / [onPermissionResult](.)

# onPermissionResult

`abstract fun onPermissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Unit`

Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult)
when permission result are received.
This method will send results to the actual caller.

