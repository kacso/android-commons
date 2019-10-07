[core](../../index.md) / [com.github.kacso.androidcommons.core.livedata](../index.md) / [SingleLiveEvent](./index.md)

# SingleLiveEvent

`class SingleLiveEvent<T> : MutableLiveData<`[`T`](index.md#T)`>`

A lifecycle-aware observable that sends only new updates after subscription, used for events like
navigation and Snackbar messages.

This avoids a common problem with events: on configuration change (like rotation) an update
can be emitted if the observer is active. This LiveData only calls the observable if there's an
explicit call to setValue() or call().

Note that only one observer is going to be notified of changes.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SingleLiveEvent()`<br>A lifecycle-aware observable that sends only new updates after subscription, used for events like navigation and Snackbar messages. |

### Functions

| Name | Summary |
|---|---|
| [call](call.md) | `fun call(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used for cases where T is Void, to make calls cleaner. |
| [observe](observe.md) | `fun observe(owner: LifecycleOwner, observer: Observer<in `[`T`](index.md#T)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setValue](set-value.md) | `fun setValue(t: `[`T`](index.md#T)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
