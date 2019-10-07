[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences.impl](../index.md) / [SharedPrefs](index.md) / [read](./read.md)

# read

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads a string value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.String)/defValue) if not found

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads a set of strings

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.collections.Set((kotlin.String)))/defValue) if not found

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads a boolean value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Boolean)/defValue) if not found

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads an integer value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Int)/defValue) if not found

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads an long value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Long)/defValue) if not found

`fun read(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, defValue: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads an float value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Float)/defValue) if not found

