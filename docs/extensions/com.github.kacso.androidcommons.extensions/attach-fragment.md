[extensions](../index.md) / [com.github.kacso.androidcommons.extensions](index.md) / [attachFragment](.)

# attachFragment

`fun <ERROR CLASS>.attachFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`
`fun <ERROR CLASS>.attachFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, tag: String, decorator: <ERROR CLASS>? = null): Unit`

Adds fragment [fragment](attach-fragment.md#com.github.kacso.androidcommons.extensions$attachFragment(, kotlin.Int, , kotlin.String, )/fragment) to [fragmentHolder](attach-fragment.md#com.github.kacso.androidcommons.extensions$attachFragment(, kotlin.Int, , kotlin.String, )/fragmentHolder).

In case that other fragment is already shown in fragmentHolder, that fragment will be hidden.
Also, if this fragment was previously added to this fragmentHolder, it will be re-shown.
Fragment will not be added to backstack.

This function is useful when using bottom navigation view.

### Parameters

`fragmentHolder` - ID of view in which fragment will be displayed

`fragment` - Fragment instance to be displayed

`tag` - Tag of fragment, used for re-attaching fragment

`decorator` - Additional actions that should be applied to this transaction (e.g. animations)