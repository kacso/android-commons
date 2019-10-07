[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [IPermissionManager](./index.md)

# IPermissionManager

`interface IPermissionManager`

Interface which defines basic functionality for managing user permissions

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [onPermissionResult](on-permission-result.md) | `abstract fun onPermissionResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult) when permission result are received. This method will send results to the actual caller. |
| [requirePermissions](require-permissions.md) | `abstract fun requirePermissions(permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, callback: `[`PermissionCallback`](../../com.github.kacso.androidcommons.permissions.callbacks/-permission-callback/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Method to be called when permission check needs to be performed |

### Inheritors

| Name | Summary |
|---|---|
| [ActivityPermissionManager](../-activity-permission-manager/index.md) | `class ActivityPermissionManager : `[`IPermissionManager`](./index.md)<br>[IPermissionManager](./index.md) implementation used on [FragmentActivity](#) |
| [FragmentPermissionManager](../-fragment-permission-manager/index.md) | `class FragmentPermissionManager : `[`IPermissionManager`](./index.md)<br>[IPermissionManager](./index.md) implementation used on [Fragment](#) |
