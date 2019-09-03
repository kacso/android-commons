[core](../../index.md) / [com.github.kacso.androidcommons.core.livedata](../index.md) / [SingleLiveEvent](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`SingleLiveEvent()`

A lifecycle-aware observable that sends only new updates after subscription, used for events like
navigation and Snackbar messages.

This avoids a common problem with events: on configuration change (like rotation) an update
can be emitted if the observer is active. This LiveData only calls the observable if theres an
explicit call to setValue() or call().

Note that only one observer is going to be notified of changes.

