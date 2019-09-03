[logger](../../index.md) / [com.github.kacso.androidcommons.logger](../index.md) / [Logger](index.md) / [log](.)

# log

`open fun log(logLevel: Int, tag: String, message: String): Unit`

Overrides [ILogger.log](../-i-logger/log.md)

Logs [message](log.md#com.github.kacso.androidcommons.logger.Logger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](log.md#com.github.kacso.androidcommons.logger.Logger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger.Logger$log(kotlin.Int, kotlin.String, kotlin.String)/tag)

### Parameters

`logLevel` - priority constant for the println method. Default value is [Log.DEBUG](#)

`tag` - Used to identify the source of a log message.  It usually identifies
the class or activity where the log call occurs.

`message` - The message you would like logged.

`open fun log(throwable: Throwable): Unit`

Overrides [ILogger.log](../-i-logger/log.md)

Logs [Throwable](#)

