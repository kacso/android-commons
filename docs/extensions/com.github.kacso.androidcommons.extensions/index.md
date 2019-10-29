[extensions](../index.md) / [com.github.kacso.androidcommons.extensions](./index.md)

## Package com.github.kacso.androidcommons.extensions

### Types

| Name | Summary |
|---|---|
| [BuildConfig](-build-config/index.md) | `class BuildConfig`<br>`class BuildConfig` |

### Type Aliases

| Name | Summary |
|---|---|
| [FragmentTransactionDecorator](-fragment-transaction-decorator.md) | `typealias FragmentTransactionDecorator = (FragmentTransaction) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Extension class for Fragment based classes |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [android.content.Context](android.content.-context/index.md) |  |
| [android.graphics.Bitmap](android.graphics.-bitmap/index.md) |  |
| [android.net.Uri](android.net.-uri/index.md) |  |
| [android.view.View](android.view.-view/index.md) |  |
| [android.view.ViewGroup](android.view.-view-group/index.md) |  |
| [android.widget.CheckBox](android.widget.-check-box/index.md) |  |
| [android.widget.TextView](android.widget.-text-view/index.md) |  |
| [androidx.fragment.app.Fragment](androidx.fragment.app.-fragment/index.md) |  |
| [androidx.fragment.app.FragmentActivity](androidx.fragment.app.-fragment-activity/index.md) |  |
| [androidx.fragment.app.FragmentManager](androidx.fragment.app.-fragment-manager/index.md) |  |
| [androidx.fragment.app.FragmentTransaction](androidx.fragment.app.-fragment-transaction/index.md) |  |
| [androidx.lifecycle.LiveData](androidx.lifecycle.-live-data/index.md) |  |
| [kotlin.ByteArray](kotlin.-byte-array/index.md) |  |
| [kotlin.Double](kotlin.-double/index.md) |  |
| [kotlin.String](kotlin.-string/index.md) |  |
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |
| [org.threeten.bp.Instant](org.threeten.bp.-instant/index.md) |  |
| [org.threeten.bp.LocalDate](org.threeten.bp.-local-date/index.md) |  |
| [org.threeten.bp.LocalDateTime](org.threeten.bp.-local-date-time/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [getSystemLocale](get-system-locale.md) | `fun getSystemLocale(): `[`Locale`](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html)<br>Get system default [Locale](http://docs.oracle.com/javase/8/docs/api/java/util/Locale.html) |
| [toLiveData](to-live-data.md) | `fun <T> `[`T`](to-live-data.md#T)`.toLiveData(): LiveData<`[`T`](to-live-data.md#T)`>`<br>Create [LiveData](#) from any value |
