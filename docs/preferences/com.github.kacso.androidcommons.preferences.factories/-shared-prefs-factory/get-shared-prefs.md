[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences.factories](../index.md) / [SharedPrefsFactory](index.md) / [getSharedPrefs](./get-shared-prefs.md)

# getSharedPrefs

`@Synchronized fun getSharedPrefs(context: Context, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ISharedPrefs`](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md)

Obtain instance of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md) for given [name](get-shared-prefs.md#com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory$getSharedPrefs(android.content.Context, kotlin.String)/name). This method will ensure that there is
always only one instance of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md) created for same [name](get-shared-prefs.md#com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory$getSharedPrefs(android.content.Context, kotlin.String)/name).

### Parameters

`context` - App context used to create [SharedPreferences](#)

`name` - name of [SharedPreferences](#) to be created

**Return**
instance of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md)

