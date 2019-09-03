[extensions](../index.md) / [com.github.kacso.androidcommons.extensions](index.md) / [addFragment](.)

# addFragment

`fun <ERROR CLASS>.addFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, decorator: <ERROR CLASS>? = null): Unit`
`fun <ERROR CLASS>.addFragment(fragmentHolder: Int, fragment: <ERROR CLASS>, decorator: <ERROR CLASS>? = null): Unit`

Adds fragment [fragment](add-fragment.md#com.github.kacso.androidcommons.extensions$addFragment(, kotlin.Int, , )/fragment) to [fragmentHolder](add-fragment.md#com.github.kacso.androidcommons.extensions$addFragment(, kotlin.Int, , )/fragmentHolder) without adding it to the backstack.
Use it for adding fragment to the empty view

### Parameters

`fragmentHolder` - ID of view in which fragment will be displayed

`fragment` - Fragment instance to be displayed

`decorator` - Additional actions that should be applied to this transaction (e.g. animations)