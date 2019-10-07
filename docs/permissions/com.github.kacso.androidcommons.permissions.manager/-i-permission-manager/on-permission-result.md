[permissions](../../index.md) / [com.github.kacso.androidcommons.permissions.manager](../index.md) / [IPermissionManager](index.md) / [onPermissionResult](./on-permission-result.md)

# onPermissionResult

`abstract fun onPermissionResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, permissions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, grantResults: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Method to be called by caller activity/fragment (@link Activity#onRequestPermissionsResult)
when permission result are received.
This method will send results to the actual caller.

