[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [CrashlyticsLogger](./index.md)

# CrashlyticsLogger

`class CrashlyticsLogger : `[`Logger`](../-logger/index.md)

[CrashlyticsLogger](./index.md) extends [Logger](../-logger/index.md) implementation by additionally to logcat logging all messages to
[Crashlytics](#) instance.

In order to use this logger, enable [Crashlytics](#) for your app.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CrashlyticsLogger(isDebug: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>[CrashlyticsLogger](./index.md) extends [Logger](../-logger/index.md) implementation by additionally to logcat logging all messages to [Crashlytics](#) instance. |

### Functions

| Name | Summary |
|---|---|
| [log](log.md) | `fun log(logLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [message](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](../-i-logger/log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)`fun log(throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
