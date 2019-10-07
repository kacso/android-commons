[core](../../index.md) / [com.github.kacso.androidcommons.core.dialogs](../index.md) / [DialogMessage](index.md) / [newInstance](./new-instance.md)

# newInstance

`fun newInstance(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, positiveLbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, dismissLbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, dismissible: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, positiveAction: `[`Action`](../../com.github.kacso.androidcommons.core/-action.md)`? = null, dismissAction: `[`Action`](../../com.github.kacso.androidcommons.core/-action.md)`? = null): `[`DialogMessage`](index.md)

Creates new instance of DialogMessage. Dialog is automatically dismissed when user
taps on any of available buttons.

### Parameters

`title` - title of dialog.
    If using default value, or null is set, no title will be displayed.

`message` - Message to be displayed. Value is required

`positiveLbl` - Label to be displayed as positive button.
    If using default value, or null is set, button will not be displayed.

`dismissLbl` - Label to be displayed as negative button.
    If using default value, or null is set, button will not be displayed.

`dismissible` - Set if dialog can be dismissed when tapped outside of view.

`positiveAction` - Function which will be called once user taps on positiveBtn

`dismissAction` - Function which will be called once user dismiss dialog

**Return**
new instance of DialogMessage

