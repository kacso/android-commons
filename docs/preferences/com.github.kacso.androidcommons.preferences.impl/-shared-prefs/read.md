[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences.impl](../index.md) / [SharedPrefs](index.md) / [read](.)

# read

`fun read(key: String, defValue: String?): String?`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads a string value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.impl.SharedPrefs$read(kotlin.String, kotlin.String)/defValue) if not found

`fun read(key: String, defValue: Set<String>?): Set<String>?`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads a set of strings

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.impl.SharedPrefs$read(kotlin.String, kotlin.collections.Set((kotlin.String)))/defValue) if not found

`fun read(key: String, defValue: Boolean): Boolean`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads a boolean value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.impl.SharedPrefs$read(kotlin.String, kotlin.Boolean)/defValue) if not found

`fun read(key: String, defValue: Int): Int`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads an integer value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.impl.SharedPrefs$read(kotlin.String, kotlin.Int)/defValue) if not found

`fun read(key: String, defValue: Long): Long`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads an long value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.impl.SharedPrefs$read(kotlin.String, kotlin.Long)/defValue) if not found

`fun read(key: String, defValue: Float): Float`

Overrides [ISharedPrefs.read](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/read.md)

Reads an float value

### Parameters

`key` - preference key

`defValue` - default expected value

**Return**
[SharedPreferences](#) value, or [defValue](read.md#com.github.kacso.androidcommons.preferences.impl.SharedPrefs$read(kotlin.String, kotlin.Float)/defValue) if not found

