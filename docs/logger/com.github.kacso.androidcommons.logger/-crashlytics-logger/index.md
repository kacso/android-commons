[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [CrashlyticsLogger](.)

# CrashlyticsLogger

`class CrashlyticsLogger : `[`Logger`](../-logger/index.md)

CrashlyticsLogger extends [Logger](../-logger/index.md) implementation by additionally to logcat logging all messages to
[Crashlytics](#) instance.

In order to use this logger, enable [Crashlytics](#) for your app.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CrashlyticsLogger(isDebug: Boolean)`<br>CrashlyticsLogger extends [Logger](../-logger/index.md) implementation by additionally to logcat logging all messages to
[Crashlytics](#) instance. |

### Functions

| Name | Summary |
|---|---|
| [log](log.md) | `fun log(logLevel: Int, tag: String, message: String): Unit`<br>Logs [message](log.md#com.github.kacso.androidcommons.logger.CrashlyticsLogger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](log.md#com.github.kacso.androidcommons.logger.CrashlyticsLogger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger.CrashlyticsLogger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)`fun log(throwable: Throwable): Unit`<br>Logs [Throwable](#) |
