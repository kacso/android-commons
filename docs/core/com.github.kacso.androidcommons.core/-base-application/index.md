[core](../../index.md) / [com.github.kacso.androidcommons.core](../index.md) / [BaseApplication](./index.md)

# BaseApplication

`abstract class BaseApplication : Application, LifecycleObserver`

Application class which defines and implements common functionalities needed on application level.
Some of functionalities in this library depends on this class, so make sure to use this in your app.

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseApplication()`<br>Application class which defines and implements common functionalities needed on application level. Some of functionalities in this library depends on this class, so make sure to use this in your app. |

### Properties

| Name | Summary |
|---|---|
| [isAppForegrounded](is-app-foregrounded.md) | `open var isAppForegrounded: `[`AtomicBoolean`](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicBoolean.html) |

### Functions

| Name | Summary |
|---|---|
| [attachBaseContext](attach-base-context.md) | `open fun attachBaseContext(base: Context): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAppTheme](get-app-theme.md) | `open fun getAppTheme(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?`<br>This method returns theme which will be used across all activities. In case that theme defined in AndroidManifest would like to be used, returned value must be null (which is default value) |
| [getDialogTheme](get-dialog-theme.md) | `open fun getDialogTheme(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?`<br>This method returns theme which will be used across all dialogs. In case that theme defined in AndroidManifest would like to be used, returned value must be null (which is default value) |
| [getUserLocale](get-user-locale.md) | `open fun getUserLocale(): `[`Locale`](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)<br>Returns locale defined by user in settings, if such option does not exist, return device default locale. |
| [onAppBackgrounded](on-app-backgrounded.md) | `fun onAppBackgrounded(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onAppForegrounded](on-app-foregrounded.md) | `fun onAppForegrounded(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `open fun onCreate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [startLogin](start-login.md) | `abstract fun startLogin(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This function should start Login activity used within your app |

### Companion Object Properties

| Name | Summary |
|---|---|
| [appContext](app-context.md) | `lateinit var appContext: Context`<br>Context of the application |
