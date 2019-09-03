[core](../../index.md) / [com.github.kacso.androidcommons.core](../index.md) / [BaseApplication](index.md) / [getDialogTheme](.)

# getDialogTheme

`open fun getDialogTheme(): Int?`

This method returns theme which will be used across all dialogs.
In case that theme defined in AndroidManifest would like to be used, returned value
must be null (which is default value)

**Return**
[StyleRes](#) representing theme to be used or null if default should be used

