[commondata](../../../index.md) / [com.github.kacso.androidcommons.data](../../index.md) / [Resource](../index.md) / [Error](./index.md)

# Error

`class Error<T> : `[`Resource`](../index.md)`<`[`T`](index.md#T)`>`

Class indicating that error occurred during data retrieval

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Error(error: `[`ErrorHolder`](../../-error-holder/index.md)`, data: `[`T`](index.md#T)`? = null)`<br>Class indicating that error occurred during data retrieval |

### Inherited Properties

| Name | Summary |
|---|---|
| [data](../data.md) | `val data: `[`T`](../index.md#T)`?`<br>Data object of type [T](../index.md#T) which this class should hold |
| [error](../error.md) | `val error: `[`ErrorHolder`](../../-error-holder/index.md)`?`<br>[ErrorHolder](../../-error-holder/index.md) representing that some error happend |

### Inherited Functions

| Name | Summary |
|---|---|
| [equals](../equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
