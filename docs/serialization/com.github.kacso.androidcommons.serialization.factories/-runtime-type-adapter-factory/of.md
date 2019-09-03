[serialization](../../index.md) / [com.github.kacso.androidcommons.serialization.factories](../index.md) / [RuntimeTypeAdapterFactory](index.md) / [of](.)

# of

`static fun <T : Any> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<T>, typeFieldName: String, maintainType: Boolean): `[`RuntimeTypeAdapterFactory`](index.md)`<T>`

Creates a new runtime type adapter using for `baseType` using `typeFieldName` as the type field name. Type field names are case sensitive. `maintainType` flag decide if the type will be stored in pojo or not.

`static fun <T : Any> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<T>, typeFieldName: String): `[`RuntimeTypeAdapterFactory`](index.md)`<T>`

Creates a new runtime type adapter using for `baseType` using `typeFieldName` as the type field name. Type field names are case sensitive.

`static fun <T : Any> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<T>): `[`RuntimeTypeAdapterFactory`](index.md)`<T>`

Creates a new runtime type adapter for `baseType` using `"type"` as the type field name.

