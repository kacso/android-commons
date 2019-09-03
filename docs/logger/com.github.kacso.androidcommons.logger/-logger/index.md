[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [Logger](.)

# Logger

`open class Logger : `[`ILogger`](../-i-logger/index.md)

Default implementation of [ILogger](../-i-logger/index.md).
It will log messages in logcat in case that app is in debug mode ([isDebug](#) is set to true)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Logger(isDebug: Boolean)`<br>Default implementation of [ILogger](../-i-logger/index.md).
It will log messages in logcat in case that app is in debug mode ([isDebug](-init-.md#com.github.kacso.androidcommons.logger.Logger$<init>(kotlin.Boolean)/isDebug) is set to true) |

### Functions

| Name | Summary |
|---|---|
| [log](log.md) | `open fun log(logLevel: Int, tag: String, message: String): Unit`<br>Logs [message](log.md#com.github.kacso.androidcommons.logger.Logger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](log.md#com.github.kacso.androidcommons.logger.Logger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger.Logger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)`open fun log(throwable: Throwable): Unit`<br>Logs [Throwable](#) |

### Inheritors

| Name | Summary |
|---|---|
| [CrashlyticsLogger](../-crashlytics-logger/index.md) | `class CrashlyticsLogger : Logger`<br>[CrashlyticsLogger](../-crashlytics-logger/index.md) extends Logger implementation by additionally to logcat logging all messages to
[Crashlytics](#) instance. |
