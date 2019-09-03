[core](../../index.md) / [com.github.kacso.androidcommons.core.repository](../index.md) / [NetworkBoundResource](index.md) / [onFetchFailed](.)

# onFetchFailed

`protected open fun onFetchFailed(error: <ERROR CLASS>): <ERROR CLASS>`

Called when network request fails with an [NetworkException](#).
Override this function in case that you need to extract server response and share it with view.
By default, function will only mask this error into [ErrorHolder](#)

**Return**
[ErrorHolder](#) containing error and messages for view

