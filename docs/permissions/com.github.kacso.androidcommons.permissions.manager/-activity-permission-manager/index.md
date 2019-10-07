[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [ActivityPermissionManager](./index.md)

# ActivityPermissionManager

`class ActivityPermissionManager : `[`IPermissionManager`](../-i-permission-manager/index.md)

[IPermissionManager](../-i-permission-manager/index.md) implementation used on [FragmentActivity](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ActivityPermissionManager(activityRef: `[`WeakReference`](http://docs.oracle.com/javase/8/docs/api/java/lang/ref/WeakReference.html)`<FragmentActivity>)`<br>[IPermissionManager](../-i-permission-manager/index.md) implementation used on [FragmentActivity](#) |

### Functions

| Name | Summary |
|---|---|
| [onPermissionResult](on-permission-result.md) | `fun onPermissionResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult) when permission result are received. This method will send results to the actual caller. |
| [requirePermissions](require-permissions.md) | `fun requirePermissions(permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, callback: `[`PermissionCallback`](../../com.github.kacso.androidcommons.permissions.callbacks/-permission-callback/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Method to be called when permission check needs to be performed |
