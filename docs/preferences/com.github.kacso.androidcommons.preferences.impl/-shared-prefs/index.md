[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences.impl](../index.md) / [SharedPrefs](.)

# SharedPrefs

`class SharedPrefs : `[`ISharedPrefs`](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md)

Default implementation of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md)

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SharedPrefs(context: <ERROR CLASS>, prefName: String)`<br>Default implementation of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md) |

### Functions

| Name | Summary |
|---|---|
| [getName](get-name.md) | `fun getName(): String` |
| [getPreferences](get-preferences.md) | `fun getPreferences(): <ERROR CLASS>`<br>Get [SharedPreferences](#) |
| [read](read.md) | `fun read(key: String, defValue: String?): String?`<br>Reads a string value`fun read(key: String, defValue: Set<String>?): Set<String>?`<br>Reads a set of strings`fun read(key: String, defValue: Boolean): Boolean`<br>Reads a boolean value`fun read(key: String, defValue: Int): Int`<br>Reads an integer value`fun read(key: String, defValue: Long): Long`<br>Reads an long value`fun read(key: String, defValue: Float): Float`<br>Reads an float value |
| [removeKey](remove-key.md) | `fun removeKey(key: String): Unit`<br>Removes key from [SharedPreferences](#) |
| [write](write.md) | `fun write(key: String, value: String): Unit`<br>Writes a string value into [SharedPreferences](#)`fun write(key: String, value: Set<String>): Unit`<br>Writes a set of strings into [SharedPreferences](#)`fun write(key: String, value: Boolean): Unit`<br>Writes a boolean value into [SharedPreferences](#)`fun write(key: String, value: Int): Unit`<br>Writes an integer value into [SharedPreferences](#)`fun write(key: String, value: Long): Unit`<br>Writes an long value into [SharedPreferences](#)`fun write(key: String, value: Float): Unit`<br>Writes an float value into [SharedPreferences](#) |
