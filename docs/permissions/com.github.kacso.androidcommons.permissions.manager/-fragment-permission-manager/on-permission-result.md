[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [FragmentPermissionManager](index.md) / [onPermissionResult](.)

# onPermissionResult

`fun onPermissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Unit`

Overrides [IPermissionManager.onPermissionResult](../-i-permission-manager/on-permission-result.md)

Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult)
when permission result are received.
This method will send results to the actual caller.

