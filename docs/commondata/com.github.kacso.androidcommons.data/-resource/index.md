[commondata](../../index.md) / [com.github.kacso.androidcommons.data](../index.md) / [Resource](./index.md)

# Resource

`sealed class Resource<T>`

Sealed class representing properties which each resource will have.
This is useful in order to transmit progress and errors through LiveData

### Parameters

`data` - Data object of type [T](index.md#T) which this class should hold

`error` - [ErrorHolder](../-error-holder/index.md) representing that some error happend

### Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `class Error<T> : `[`Resource`](./index.md)`<`[`T`](-error/index.md#T)`>`<br>Class indicating that error occurred during data retrieval |
| [Loading](-loading/index.md) | `class Loading<T> : `[`Resource`](./index.md)`<`[`T`](-loading/index.md#T)`>`<br>Class indicating that data retrieval is in progress |
| [Success](-success/index.md) | `class Success<T> : `[`Resource`](./index.md)`<`[`T`](-success/index.md#T)`>`<br>Class indicating that data retrieval was successful |

### Properties

| Name | Summary |
|---|---|
| [data](data.md) | `val data: `[`T`](index.md#T)`?`<br>Data object of type [T](index.md#T) which this class should hold |
| [error](error.md) | `val error: `[`ErrorHolder`](../-error-holder/index.md)`?`<br>[ErrorHolder](../-error-holder/index.md) representing that some error happend |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Error](-error/index.md) | `class Error<T> : `[`Resource`](./index.md)`<`[`T`](-error/index.md#T)`>`<br>Class indicating that error occurred during data retrieval |
| [Loading](-loading/index.md) | `class Loading<T> : `[`Resource`](./index.md)`<`[`T`](-loading/index.md#T)`>`<br>Class indicating that data retrieval is in progress |
| [Success](-success/index.md) | `class Success<T> : `[`Resource`](./index.md)`<`[`T`](-success/index.md#T)`>`<br>Class indicating that data retrieval was successful |
