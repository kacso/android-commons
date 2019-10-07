[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences](../index.md) / [ISharedPrefs](index.md) / [read](./read.md)

# read

`abstract fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`

Reads a string value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.String)/defValue) if not found

`abstract fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`

Reads a set of strings

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.collections.Set((kotlin.String)))/defValue) if not found

`abstract fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Reads a boolean value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Boolean)/defValue) if not found

`abstract fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Reads an integer value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Int)/defValue) if not found

`abstract fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Reads an long value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Long)/defValue) if not found

`abstract fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)

Reads an float value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Float)/defValue) if not found

