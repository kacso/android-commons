[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [ActivityPermissionManager](.)

# ActivityPermissionManager

`class ActivityPermissionManager : `[`IPermissionManager`](../-i-permission-manager/index.md)

[IPermissionManager](../-i-permission-manager/index.md) implementation used on [FragmentActivity](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ActivityPermissionManager(activityRef: `[`WeakReference`](http://docs.oracle.com/javase/8/docs/api/java/lang/ref/WeakReference.html)`<<ERROR CLASS>>)`<br>[IPermissionManager](../-i-permission-manager/index.md) implementation used on [FragmentActivity](#) |

### Functions

| Name | Summary |
|---|---|
| [onPermissionResult](on-permission-result.md) | `fun onPermissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray): Unit`<br>Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult)
when permission result are received.
This method will send results to the actual caller. |
| [requirePermissions](require-permissions.md) | `fun requirePermissions(permissions: Array<String>, callback: `[`PermissionCallback`](../../com.github.kacso.androidcommons.permissions.callbacks/-permission-callback/index.md)`): Int`<br>Method to be called when permission check needs to be performed |
