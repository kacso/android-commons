[logger](../index.md) / [com.github.kacso.androidcommons.logger](./index.md)

## Package com.github.kacso.androidcommons.logger

### Types

| Name | Summary |
|---|---|
| [BuildConfig](-build-config/index.md) | `class BuildConfig`<br>`class BuildConfig` |
| [CrashlyticsLogger](-crashlytics-logger/index.md) | `class CrashlyticsLogger : `[`Logger`](-logger/index.md)<br>[CrashlyticsLogger](-crashlytics-logger/index.md) extends [Logger](-logger/index.md) implementation by additionally to logcat logging all messages to [Crashlytics](#) instance. |
| [ILogger](-i-logger/index.md) | `interface ILogger`<br>Interface defining basic functionalities that each logger needs to implement in order to properly log messages. Instance of implementation of this interface are used in Logging extensions. |
| [Logger](-logger/index.md) | `open class Logger : `[`ILogger`](-i-logger/index.md)<br>Default implementation of [ILogger](-i-logger/index.md). It will log messages in logcat in case that app is in debug mode ([isDebug](#) is set to true) |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.Throwable](kotlin.-throwable/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [LOGGER](-l-o-g-g-e-r.md) | `var LOGGER: `[`ILogger`](-i-logger/index.md)`?`<br>Instance of [ILogger](-i-logger/index.md) to be used with log extension functions Set it in application onCreate method in order to be able to use logging extensions in whole app |

### Functions

| Name | Summary |
|---|---|
| [log](log.md) | `fun log(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [message](log.md#com.github.kacso.androidcommons.logger$log(kotlin.String, kotlin.String)/message) with logLevel set to [Log.DEBUG](#) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger$log(kotlin.String, kotlin.String)/tag) using [LOGGER](-l-o-g-g-e-r.md) instance`fun log(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [message](log.md#com.github.kacso.androidcommons.logger$log(kotlin.String)/message) logLevel set to [Log.DEBUG](#) and without tag using [LOGGER](-l-o-g-g-e-r.md) instance`fun log(logLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = Log.DEBUG, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "LOGGER", message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Logs [message](log.md#com.github.kacso.androidcommons.logger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](log.md#com.github.kacso.androidcommons.logger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger$log(kotlin.Int, kotlin.String, kotlin.String)/tag) using [LOGGER](-l-o-g-g-e-r.md) instance |
