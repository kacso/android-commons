[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [ActivityPermissionManager](index.md) / [requirePermissions](.)

# requirePermissions

`fun requirePermissions(permissions: Array<String>, callback: `[`PermissionCallback`](../../com.github.kacso.androidcommons.permissions.callbacks/-permission-callback/index.md)`): Int`

Overrides [IPermissionManager.requirePermissions](../-i-permission-manager/require-permissions.md)

Method to be called when permission check needs to be performed

### Parameters

`permissions` - Array of required permissions to perform some task

`callback` - Callback on which result will be returned

**Return**
ID of permission check request

