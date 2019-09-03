[extensions](../index.md) / [com.github.kacso.androidcommons.extensions](.)

## Package com.github.kacso.androidcommons.extensions

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.ByteArray](kotlin.-byte-array/index.md) |  |
| [kotlin.Double](kotlin.-double/index.md) |  |
| [kotlin.String](kotlin.-string/index.md) |  |
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [actionBarHeight](action-bar-height.md) | `fun <ERROR CLASS>.actionBarHeight(): Int`<br>Calculates height of action bar |
| [addFragment](add-fragment.md) | `fun <ERROR CLASS>.addFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, decorator: <ERROR CLASS>? = null): Unit`<br>`fun <ERROR CLASS>.addFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, decorator: <ERROR CLASS>? = null): Unit`<br>Adds fragment [fragment](add-fragment.md#com.github.kacso.androidcommons.extensions$addFragment(, kotlin.Int, , )/fragment) to [fragmentHolder](add-fragment.md#com.github.kacso.androidcommons.extensions$addFragment(, kotlin.Int, , )/fragmentHolder) without adding it to the backstack.
Use it for adding fragment to the empty view |
| [animateBottomIn](animate-bottom-in.md) | `fun <ERROR CLASS>.animateBottomIn(): Unit`<br>Animates move of view from bottom of the screen to the defined position |
| [animateBottomOut](animate-bottom-out.md) | `fun <ERROR CLASS>.animateBottomOut(): Unit`<br>Animates move of view from current position to the bottom of the screen and hides the view |
| [animateMarginChange](animate-margin-change.md) | `fun <ERROR CLASS>.animateMarginChange(topMargin: Int?, bottomMargin: Int?, leftMargin: Int?, rightMargin: Int?): Unit`<br>Animate movement of view due to margin change.
In case that margin is null, current margin value will be used. |
| [animateMove](animate-move.md) | `fun <ERROR CLASS>.animateMove(x: Float, y: Float): Unit`<br>Animates moving view from current position to new coordinates |
| [atEndOfDay](at-end-of-day.md) | `fun <ERROR CLASS>.atEndOfDay(): <ERROR CLASS>`<br>Converts [LocalDate](#) to point to end of a day |
| [atEndOfMonth](at-end-of-month.md) | `fun <ERROR CLASS>.atEndOfMonth(): <ERROR CLASS>`<br>Converts [LocalDate](#) to point to last day of a month |
| [atStartOfMonth](at-start-of-month.md) | `fun <ERROR CLASS>.atStartOfMonth(): <ERROR CLASS>`<br>Converts [LocalDate](#) to point to first day of a month |
| [attachFragment](attach-fragment.md) | `fun <ERROR CLASS>.attachFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`<br>`fun <ERROR CLASS>.attachFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`<br>Adds fragment [fragment](attach-fragment.md#com.github.kacso.androidcommons.extensions$attachFragment(, kotlin.Int, , kotlin.String, )/fragment) to [fragmentHolder](attach-fragment.md#com.github.kacso.androidcommons.extensions$attachFragment(, kotlin.Int, , kotlin.String, )/fragmentHolder). |
| [clearFragmentHistory](clear-fragment-history.md) | `fun <ERROR CLASS>.clearFragmentHistory(): Unit`<br>Clears all fragments from backstack |
| [decorate](decorate.md) | `fun <ERROR CLASS>.decorate(decorator: <ERROR CLASS>?): <ERROR CLASS>`<br>Add additional action to [FragmentTransaction](#) before committing |
| [getCurrentLocale](get-current-locale.md) | `fun <ERROR CLASS>.getCurrentLocale(): `[`Locale`](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)<br>Get [Locale](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html) currently used by app |
| [getDisplayName](get-display-name.md) | `fun <ERROR CLASS>.getDisplayName(contentResolver: <ERROR CLASS>): String`<br>Returns display file name of [this](#) using [contentResolver](get-display-name.md#com.github.kacso.androidcommons.extensions$getDisplayName(, )/contentResolver) |
| [getHeightOfView](get-height-of-view.md) | `fun <ERROR CLASS>.getHeightOfView(): Int`<br>Measures height of view |
| [getSupportColor](get-support-color.md) | `fun <ERROR CLASS>.getSupportColor(color: Int): Int`<br>Get SDK independent color from resources |
| [getSystemLocale](get-system-locale.md) | `fun getSystemLocale(): `[`Locale`](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)<br>Get system default [Locale](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html) |
| [getThemeColor](get-theme-color.md) | `fun <ERROR CLASS>.getThemeColor(attr: Int): Int`<br>Get color defined for active theme |
| [getWidthOfView](get-width-of-view.md) | `fun <ERROR CLASS>.getWidthOfView(): Int`<br>Measures width of view |
| [goBack](go-back.md) | `fun <ERROR CLASS>.goBack(): Unit`<br>Performs back action on activity.
In case that there is fragments on the backstack, fragment on top of the stack will be
displayed to the user. Otherwise, activity will be finished`fun <ERROR CLASS>.goBack(): Boolean`<br>Goes recursively through all displayed fragments and pops last displayed child |
| [hide](hide.md) | `fun <ERROR CLASS>.hide(shouldAnimate: Boolean = true): Unit`<br>Hide view from the user |
| [hideKeyboard](hide-keyboard.md) | `fun <ERROR CLASS>.hideKeyboard(): Unit`<br>Hide keyboard from UI |
| [openGoogleMapNavigation](open-google-map-navigation.md) | `fun <ERROR CLASS>.openGoogleMapNavigation(latitude: Double, longitude: Double): Unit`<br>Open Google Map app at location with coordinates ([latitude](open-google-map-navigation.md#com.github.kacso.androidcommons.extensions$openGoogleMapNavigation(, kotlin.Double, kotlin.Double)/latitude), [longitude](open-google-map-navigation.md#com.github.kacso.androidcommons.extensions$openGoogleMapNavigation(, kotlin.Double, kotlin.Double)/longitude)) |
| [openNavigation](open-navigation.md) | `fun <ERROR CLASS>.openNavigation(latitude: Double, longitude: Double): Unit`<br>Open default navigation app at location with coordinates ([latitude](open-navigation.md#com.github.kacso.androidcommons.extensions$openNavigation(, kotlin.Double, kotlin.Double)/latitude), [longitude](open-navigation.md#com.github.kacso.androidcommons.extensions$openNavigation(, kotlin.Double, kotlin.Double)/longitude)) |
| [performVoiceCall](perform-voice-call.md) | `fun <ERROR CLASS>.performVoiceCall(number: String): Unit` |
| [setHtmlText](set-html-text.md) | `fun <ERROR CLASS>.setHtmlText(value: String?): Unit`<br>Formats string as HTML and displays it to the user |
| [setLiveChecked](set-live-checked.md) | `fun <ERROR CLASS>.setLiveChecked(owner: <ERROR CLASS>, value: <ERROR CLASS><Boolean>): Unit`<br>Displays real time checkbox value according to LiveData parameter |
| [setLiveHtmlText](set-live-html-text.md) | `fun <ERROR CLASS>.setLiveHtmlText(owner: <ERROR CLASS>, value: <ERROR CLASS><String>): Unit`<br>Displays real time text value as HTML according to LiveData parameter |
| [setLiveText](set-live-text.md) | `fun <ERROR CLASS>.setLiveText(owner: <ERROR CLASS>, value: <ERROR CLASS><String>): Unit`<br>Displays real time text value according to LiveData parameter |
| [show](show.md) | `fun <ERROR CLASS>.show(shouldAnimate: Boolean = true): Unit`<br>Display view to the user |
| [showFragment](show-fragment.md) | `fun <ERROR CLASS>.showFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`<br>`fun <ERROR CLASS>.showFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`<br>Replaces fragment [fragment](show-fragment.md#com.github.kacso.androidcommons.extensions$showFragment(, kotlin.Int, , kotlin.String, )/fragment) on place of [fragmentHolder](show-fragment.md#com.github.kacso.androidcommons.extensions$showFragment(, kotlin.Int, , kotlin.String, )/fragmentHolder).
Also, fragment is added to backstack in order to support back function on fragments. |
| [showKeyboard](show-keyboard.md) | `fun <ERROR CLASS>.showKeyboard(): Unit`<br>Extension class for View class |
| [toByteArray](to-byte-array.md) | `fun <ERROR CLASS>.toByteArray(): ByteArray`<br>Convert bitmap to byte array using ByteBuffer. |
| [toInstant](to-instant.md) | `fun <ERROR CLASS>.toInstant(zoneId: <ERROR CLASS> = ZoneId.systemDefault()): <ERROR CLASS>`<br>Converts [LocalDate](#) to [Instant](#) using [zoneId](to-instant.md#com.github.kacso.androidcommons.extensions$toInstant(, )/zoneId)`fun <ERROR CLASS>.toInstant(zoneId: <ERROR CLASS> = ZoneId.systemDefault()): <ERROR CLASS>`<br>Converts [LocalDateTime](#) to [Instant](#) using [zoneId](to-instant.md#com.github.kacso.androidcommons.extensions$toInstant(, )/zoneId) |
| [toLiveData](to-live-data.md) | `fun <T> T.toLiveData(): <ERROR CLASS><T>`<br>Create [LiveData](#) from any value |
| [toLocalDate](to-local-date.md) | `fun <ERROR CLASS>.toLocalDate(zoneId: <ERROR CLASS> = ZoneId.systemDefault()): <ERROR CLASS>`<br>Converts [Instant](#) to [LocalDate](#) using [zoneId](to-local-date.md#com.github.kacso.androidcommons.extensions$toLocalDate(, )/zoneId) |
| [toLocalDateTime](to-local-date-time.md) | `fun <ERROR CLASS>.toLocalDateTime(zoneId: <ERROR CLASS> = ZoneId.systemDefault()): <ERROR CLASS>`<br>Converts [Instant](#) to [LocalDateTime](#) using [zoneId](to-local-date-time.md#com.github.kacso.androidcommons.extensions$toLocalDateTime(, )/zoneId) |
| [toLocalTime](to-local-time.md) | `fun <ERROR CLASS>.toLocalTime(zoneId: <ERROR CLASS> = ZoneId.systemDefault()): <ERROR CLASS>`<br>Converts [Instant](#) to [LocalTime](#) using [zoneId](to-local-time.md#com.github.kacso.androidcommons.extensions$toLocalTime(, )/zoneId) |
| [toUserDefinedLocaleContext](to-user-defined-locale-context.md) | `fun <ERROR CLASS>.toUserDefinedLocaleContext(newLocale: `[`Locale`](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)`): <ERROR CLASS>`<br>Set locale to user defined locale (needed to support app language selection by user).
Make sure to use new [Context](#) in order to use new [Locale](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html) |
| [toZonedDateTime](to-zoned-date-time.md) | `fun <ERROR CLASS>.toZonedDateTime(zoneId: <ERROR CLASS> = ZoneId.systemDefault()): <ERROR CLASS>`<br>Converts [LocalDate](#) to [ZonedDateTime](#) using [zoneId](to-zoned-date-time.md#com.github.kacso.androidcommons.extensions$toZonedDateTime(, )/zoneId) |
| [touch](touch.md) | `fun <ERROR CLASS>.touch(delay: Long): Unit`<br>Performs touch event on current view with delay |
