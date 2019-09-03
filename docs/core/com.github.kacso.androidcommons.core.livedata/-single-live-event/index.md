[core](../../index.md) / [com.github.kacso.androidcommons.core.livedata](../index.md) / [SingleLiveEvent](.)

# SingleLiveEvent

`class SingleLiveEvent<T>`

A lifecycle-aware observable that sends only new updates after subscription, used for events like
navigation and Snackbar messages.

This avoids a common problem with events: on configuration change (like rotation) an update
can be emitted if the observer is active. This LiveData only calls the observable if theres an
explicit call to setValue() or call().

Note that only one observer is going to be notified of changes.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SingleLiveEvent()`<br>A lifecycle-aware observable that sends only new updates after subscription, used for events like
navigation and Snackbar messages. |

### Functions

| Name | Summary |
|---|---|
| [call](call.md) | `fun call(): Unit`<br>Used for cases where T is Void, to make calls cleaner. |
| [observe](observe.md) | `fun observe(owner: <ERROR CLASS>, observer: <ERROR CLASS><in T>): Unit` |
| [setValue](set-value.md) | `fun setValue(t: T?): Unit` |
