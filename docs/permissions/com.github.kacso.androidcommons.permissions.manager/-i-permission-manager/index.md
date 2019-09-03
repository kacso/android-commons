[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [IPermissionManager](.)

# IPermissionManager

`interface IPermissionManager`

Interface which defines basic functionality for managing user permissions

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [onPermissionResult](on-permission-result.md) | `abstract fun onPermissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Unit`<br>Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult)
when permission result are received.
This method will send results to the actual caller. |
| [requirePermissions](require-permissions.md) | `abstract fun requirePermissions(permissions: Array<String>, callback: `[`PermissionCallback`](../../com.github.kacso.androidcommons.permissions.callbacks/-permission-callback/index.md)`): Int`<br>Method to be called when permission check needs to be performed |

### Inheritors

| Name | Summary |
|---|---|
| [ActivityPermissionManager](../-activity-permission-manager/index.md) | `class ActivityPermissionManager : IPermissionManager`<br>IPermissionManager implementation used on [FragmentActivity](#) |
| [FragmentPermissionManager](../-fragment-permission-manager/index.md) | `class FragmentPermissionManager : IPermissionManager`<br>IPermissionManager implementation used on [Fragment](#) |
