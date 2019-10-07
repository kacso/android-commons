[core](../../index.md) / [com.github.kacso.androidcommons.core.activities](../index.md) / [BaseActivity](index.md) / [getUserLocale](./get-user-locale.md)

# getUserLocale

`open fun getUserLocale(context: Context): `[`Locale`](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)

Returns locale defined by user in settings, if such option does not exist, return device default locale.

Default behaviour, returns locale from [BaseApplication.getUserLocale](../../com.github.kacso.androidcommons.core/-base-application/get-user-locale.md) or default locale if [BaseApplication](../../com.github.kacso.androidcommons.core/-base-application/index.md)
could not be retrieved

