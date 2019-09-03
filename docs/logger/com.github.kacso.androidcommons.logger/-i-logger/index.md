[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [ILogger](.)

# ILogger

`interface ILogger`

Interface defining basic functionalities that each logger needs to implement in order to properly log messages.
Instance of implementation of this interface are used in Logging extensions.

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [log](log.md) | `abstract fun log(logLevel: Int = Log.DEBUG, tag: String = "", message: String): Unit`<br>Logs [message](log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)`abstract fun log(throwable: Throwable): Unit`<br>Logs [Throwable](#) |

### Inheritors

| Name | Summary |
|---|---|
| [Logger](../-logger/index.md) | `open class Logger : ILogger`<br>Default implementation of ILogger.
It will log messages in logcat in case that app is in debug mode ([isDebug](#) is set to true) |
