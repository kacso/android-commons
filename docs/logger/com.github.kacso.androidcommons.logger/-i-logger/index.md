[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [ILogger](./index.md)

# ILogger

`interface ILogger`

Interface defining basic functionalities that each logger needs to implement in order to properly log messages.
Instance of implementation of this interface are used in Logging extensions.

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [log](log.md) | `abstract fun log(logLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = Log.DEBUG, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [message](log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger.ILogger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)`abstract fun log(throwable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Logger](../-logger/index.md) | `open class Logger : `[`ILogger`](./index.md)<br>Default implementation of [ILogger](./index.md). It will log messages in logcat in case that app is in debug mode ([isDebug](#) is set to true) |
