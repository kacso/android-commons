[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences.factories](../index.md) / [SharedPrefsFactory](./index.md)

# SharedPrefsFactory

`object SharedPrefsFactory`

Factory class which generates repositories available in preferences module

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [getSharedPrefs](get-shared-prefs.md) | `fun getSharedPrefs(context: Context, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ISharedPrefs`](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md)<br>Obtain instance of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md) for given [name](get-shared-prefs.md#com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory$getSharedPrefs(android.content.Context, kotlin.String)/name). This method will ensure that there is always only one instance of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md) created for same [name](get-shared-prefs.md#com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory$getSharedPrefs(android.content.Context, kotlin.String)/name). |
