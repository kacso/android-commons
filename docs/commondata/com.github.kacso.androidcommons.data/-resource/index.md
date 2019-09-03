[commondata](../../index.md) / [com.github.kacso.androidcommons.data](../index.md) / [Resource](.)

# Resource

`sealed class Resource<T>`

Sealed class representing properties which each resource will have.
This is useful in order to transmit progress and errors through LiveData

### Parameters

`data` - Data object of type [T](#) which this class should hold

`error` - [ErrorHolder](../-error-holder/index.md) representing that some error happend

### Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `class Error<T> : Resource<T>`<br>Class indicating that error occurred during data retrieval |
| [Loading](-loading/index.md) | `class Loading<T> : Resource<T>`<br>Class indicating that data retrieval is in progress |
| [Success](-success/index.md) | `class Success<T> : Resource<T>`<br>Class indicating that data retrieval was successful |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: T?` |
| [error](error.md) | `val error: `[`ErrorHolder`](../-error-holder/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `open fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `open fun hashCode(): Int` |

### Inheritors

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `class Error<T> : Resource<T>`<br>Class indicating that error occurred during data retrieval |
| [Loading](-loading/index.md) | `class Loading<T> : Resource<T>`<br>Class indicating that data retrieval is in progress |
| [Success](-success/index.md) | `class Success<T> : Resource<T>`<br>Class indicating that data retrieval was successful |
