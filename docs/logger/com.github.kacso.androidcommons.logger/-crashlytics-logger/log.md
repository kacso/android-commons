[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [CrashlyticsLogger](index.md) / [log](./log.md)

# log

`fun log(logLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [Logger.log](../-logger/log.md)

Logs [message](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)

### Parameters

`logLevel` - priority constant for the println method. Default value is [Log.DEBUG](#)

`tag` - Used to identify the source of a log message.  It usually identifies
    the class or activity where the log call occurs.

`message` - The message you would like logged.`fun log(throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [Logger.log](../-logger/log.md)

Logs [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)

