[extensions](../index.md) / [com.github.kacso.androidcommons.extensions](index.md) / [goBack](.)

# goBack

`fun <ERROR CLASS>.goBack(): Unit`

Performs back action on activity.
In case that there is fragments on the backstack, fragment on top of the stack will be
displayed to the user. Otherwise, activity will be finished

`fun <ERROR CLASS>.goBack(): Boolean`

Goes recursively through all displayed fragments and pops last displayed child

**Return**
true if back action was performed, otherwise false

