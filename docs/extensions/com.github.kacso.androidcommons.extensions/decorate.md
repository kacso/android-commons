[extensions](../index.md) / [com.github.kacso.androidcommons.extensions](index.md) / [decorate](.)

# decorate

`fun <ERROR CLASS>.decorate(decorator: <ERROR CLASS>?): <ERROR CLASS>`

Add additional action to [FragmentTransaction](#) before committing

### Parameters

`decorator` - Instance of [FragmentTransactionDecorator](#) that will perform decoration. If set to null, no
action will be performed

**Return**
Returns same [FragmentTransaction](#) instance

