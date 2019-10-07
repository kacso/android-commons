[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [ActivityPermissionManager](index.md) / [requirePermissions](./require-permissions.md)

# requirePermissions

`fun requirePermissions(permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, callback: `[`PermissionCallback`](../../com.github.kacso.androidcommons.permissions.callbacks/-permission-callback/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Overrides [IPermissionManager.requirePermissions](../-i-permission-manager/require-permissions.md)

Method to be called when permission check needs to be performed

### Parameters

`permissions` - Array of required permissions to perform some task

`callback` - Callback on which result will be returned

**Return**
ID of permission check request

