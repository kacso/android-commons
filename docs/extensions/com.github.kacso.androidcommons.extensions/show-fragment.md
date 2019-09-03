[extensions](../index.md) / [com.github.kacso.androidcommons.extensions](index.md) / [showFragment](.)

# showFragment

`fun <ERROR CLASS>.showFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`
`fun <ERROR CLASS>.showFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`

Replaces fragment [fragment](show-fragment.md#com.github.kacso.androidcommons.extensions$showFragment(, kotlin.Int, , kotlin.String, )/fragment) on place of [fragmentHolder](show-fragment.md#com.github.kacso.androidcommons.extensions$showFragment(, kotlin.Int, , kotlin.String, )/fragmentHolder).
Also, fragment is added to backstack in order to support back function on fragments.

### Parameters

`fragmentHolder` - ID of view in which fragment will be displayed

`fragment` - Fragment instance to be displayed

`tag` - Tag of fragment, used for adding to backstack

`decorator` - Additional actions that should be applied to this transaction (e.g. animations)