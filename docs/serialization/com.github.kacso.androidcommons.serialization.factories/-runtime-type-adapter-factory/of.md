[serialization](../../index.md) / [com.github.kacso.androidcommons.serialization.factories](../index.md) / [RuntimeTypeAdapterFactory](index.md) / [of](./of.md)

# of

`static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](of.md#T)`>, typeFieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, maintainType: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`RuntimeTypeAdapterFactory`](index.md)`<`[`T`](of.md#T)`>`

Creates a new runtime type adapter using for `baseType` using `typeFieldName` as the type field name. Type field names are case sensitive. `maintainType` flag decide if the type will be stored in pojo or not.

`static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](of.md#T)`>, typeFieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`RuntimeTypeAdapterFactory`](index.md)`<`[`T`](of.md#T)`>`

Creates a new runtime type adapter using for `baseType` using `typeFieldName` as the type field name. Type field names are case sensitive.

`static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](of.md#T)`>): `[`RuntimeTypeAdapterFactory`](index.md)`<`[`T`](of.md#T)`>`

Creates a new runtime type adapter for `baseType` using `"type"` as the type field name.

