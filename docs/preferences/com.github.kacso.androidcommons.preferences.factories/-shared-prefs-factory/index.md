[preferences](../../index.md) / [com.github.kacso.androidcommons.preferences.factories](../index.md) / [SharedPrefsFactory](.)

# SharedPrefsFactory

`object SharedPrefsFactory`

Factory class which generates repositories available in preferences module

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [getSharedPrefs](get-shared-prefs.md) | `fun getSharedPrefs(context: <ERROR CLASS>, name: String): `[`ISharedPrefs`](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md)<br>Obtain instance of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md) for given [name](get-shared-prefs.md#com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory$getSharedPrefs(, kotlin.String)/name). This method will ensure that there is
always only one instance of [ISharedPrefs](../../com.github.kacso.androidcommons.preferences/-i-shared-prefs/index.md) created for same [name](get-shared-prefs.md#com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory$getSharedPrefs(, kotlin.String)/name). |
