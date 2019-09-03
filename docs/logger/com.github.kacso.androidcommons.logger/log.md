[logger](../index.md) / [com.github.kacso.androidcommons.logger](index.md) / [log](.)

# log

`fun log(tag: String, message: String): Unit`

Logs [message](log.md#com.github.kacso.androidcommons.logger$log(kotlin.String, kotlin.String)/message) with logLevel set to [Log.DEBUG](#) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger$log(kotlin.String, kotlin.String)/tag) using [LOGGER](-l-o-g-g-e-r.md) instance

### Parameters

`tag` - Used to identify the source of a log message.  It usually identifies
the class or activity where the log call occurs.

`message` - The message you would like logged.

`fun log(message: String): Unit`

Logs [message](log.md#com.github.kacso.androidcommons.logger$log(kotlin.String)/message) logLevel set to [Log.DEBUG](#) and without tag using [LOGGER](-l-o-g-g-e-r.md) instance

### Parameters

`message` - The message you would like logged.

`fun log(logLevel: Int = Log.DEBUG, tag: String = "", message: String): Unit`

Logs [message](log.md#com.github.kacso.androidcommons.logger$log(kotlin.Int, kotlin.String, kotlin.String)/message) with log level set to [logLevel](log.md#com.github.kacso.androidcommons.logger$log(kotlin.Int, kotlin.String, kotlin.String)/logLevel) and tag set to [tag](log.md#com.github.kacso.androidcommons.logger$log(kotlin.Int, kotlin.String, kotlin.String)/tag) using [LOGGER](-l-o-g-g-e-r.md) instance

### Parameters

`logLevel` - priority constant for the println method. Default value is [Log.DEBUG](#)

`tag` - Used to identify the source of a log message.  It usually identifies
the class or activity where the log call occurs.

`message` - The message you would like logged.