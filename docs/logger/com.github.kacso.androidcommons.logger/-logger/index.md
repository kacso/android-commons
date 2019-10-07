[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [Logger](./index.md)

# Logger

`open class Logger : `[`ILogger`](../-i-logger/index.md)

Default implementation of [ILogger](../-i-logger/index.md).
It will log messages in logcat in case that app is in debug mode ([isDebug](#) is set to true)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Logger(isDebug: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>Default implementation of [ILogger](../-i-logger/index.md). It will log messages in logcat in case that app is in debug mode ([isDebug](#) is set to true) |

### Functions

| Name | Summary |
|---|---|
| [log](log.md) | `open fun log(logLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [message](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)`open fun log(throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [CrashlyticsLogger](../-crashlytics-logger/index.md) | `class CrashlyticsLogger : `[`Logger`](./index.md)<br>[CrashlyticsLogger](../-crashlytics-logger/index.md) extends [Logger](./index.md) implementation by additionally to logcat logging all messages to [Crashlytics](#) instance. |
