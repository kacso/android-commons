[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences](../index.md) / [ISharedPrefs](index.md) / [read](.)

# read

`abstract fun read(key: String, defValue: String?): String?`

Reads a string value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.String)/defValue) if not found

`abstract fun read(key: String, defValue: Set<String>?): Set<String>?`

Reads a set of strings

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.collections.Set((kotlin.String)))/defValue) if not found

`abstract fun read(key: String, defValue: Boolean): Boolean`

Reads a boolean value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Boolean)/defValue) if not found

`abstract fun read(key: String, defValue: Int): Int`

Reads an integer value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Int)/defValue) if not found

`abstract fun read(key: String, defValue: Long): Long`

Reads an long value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Long)/defValue) if not found

`abstract fun read(key: String, defValue: Float): Float`

Reads an float value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.ISharedPrefs$read(kotlin.String, kotlin.Float)/defValue) if not found

