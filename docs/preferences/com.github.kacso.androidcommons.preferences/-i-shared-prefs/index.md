[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences](../index.md) / [ISharedPrefs](.)

# ISharedPrefs

`interface ISharedPrefs`

Interface defining basic functionalities that subclasses needs to implement to wrap [SharedPreferences](#) calls.
This util is used to remove boilerplate from the user when using [SharedPreferences](#).

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [getName](get-name.md) | `abstract fun getName(): String` |
| [getPreferences](get-preferences.md) | `abstract fun getPreferences(): <ERROR CLASS>`<br>Get [SharedPreferences](#) |
| [read](read.md) | `abstract fun read(key: String, defValue: String?): String?`<br>Reads a string value`abstract fun read(key: String, defValue: Set<String>?): Set<String>?`<br>Reads a set of strings`abstract fun read(key: String, defValue: Boolean): Boolean`<br>Reads a boolean value`abstract fun read(key: String, defValue: Int): Int`<br>Reads an integer value`abstract fun read(key: String, defValue: Long): Long`<br>Reads an long value`abstract fun read(key: String, defValue: Float): Float`<br>Reads an float value |
| [removeKey](remove-key.md) | `abstract fun removeKey(key: String): Unit`<br>Removes key from [SharedPreferences](#) |
| [write](write.md) | `abstract fun write(key: String, value: String): Unit`<br>Writes a string value into [SharedPreferences](#)`abstract fun write(key: String, value: Set<String>): Unit`<br>Writes a set of strings into [SharedPreferences](#)`abstract fun write(key: String, value: Boolean): Unit`<br>Writes a boolean value into [SharedPreferences](#)`abstract fun write(key: String, value: Int): Unit`<br>Writes an integer value into [SharedPreferences](#)`abstract fun write(key: String, value: Long): Unit`<br>Writes an long value into [SharedPreferences](#)`abstract fun write(key: String, value: Float): Unit`<br>Writes an float value into [SharedPreferences](#) |

### Inheritors

| Name | Summary |
|---|---|
| [SharedPrefs](../../com.github.kacso.androidcommons.preferences.impl/-shared-prefs/index.md) | `class SharedPrefs : ISharedPrefs`<br>Default implementation of ISharedPrefs |
