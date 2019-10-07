[serialization](../../index.md) / [com.github.kacso.androidcommons.serialization.factories](../index.md) / [RuntimeTypeAdapterFactory](./index.md)

# RuntimeTypeAdapterFactory

`class RuntimeTypeAdapterFactory<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : TypeAdapterFactory`

Adapts values whose runtime type may differ from their declaration type. This is necessary when a field's type is not the same type that GSON should create when deserializing that field. For example, consider these types:

```
`abstract class Shape { int x; int y; } class Circle extends Shape { int radius; } class Rectangle extends Shape { int width; int height; } class Diamond extends Shape { int width; int height; } class Drawing { Shape bottomShape; Shape topShape; } `
```



Without additional type information, the serialized JSON is ambiguous. Is the bottom shape in this drawing a rectangle or a diamond?

```
`{ "bottomShape": { "width": 10, "height": 5, "x": 0, "y": 0 }, "topShape": { "radius": 2, "x": 4, "y": 1 } }`
```

 This class addresses this problem by adding type information to the serialized JSON and honoring that type information when the JSON is deserialized:

```
`{ "bottomShape": { "type": "Diamond", "width": 10, "height": 5, "x": 0, "y": 0 }, "topShape": { "type": "Circle", "radius": 2, "x": 4, "y": 1 } }`
```

 Both the type field name (`"type"`) and the type labels (`"Rectangle"`) are configurable. Registering Types Create a `RuntimeTypeAdapterFactory` by passing the base type and type field name to the ``[`#of`](#) factory method. If you don't supply an explicit type field name, `"type"` will be used.

```
`RuntimeTypeAdapterFactory<Shape> shapeAdapterFactory = RuntimeTypeAdapterFactory.of(Shape.class, "type"); `
```

 Next register all of your subtypes. Every subtype must be explicitly registered. This protects your application from injection attacks. If you don't supply an explicit type label, the type's simple name will be used.

```
`shapeAdapterFactory.registerSubtype(Rectangle.class, "Rectangle"); shapeAdapterFactory.registerSubtype(Circle.class, "Circle"); shapeAdapterFactory.registerSubtype(Diamond.class, "Diamond"); `
```

 Finally, register the type adapter factory in your application's GSON builder:

```
`Gson gson = new GsonBuilder() .registerTypeAdapterFactory(shapeAdapterFactory) .create(); `
```

 Like `GsonBuilder`, this API supports chaining:

```
`RuntimeTypeAdapterFactory<Shape> shapeAdapterFactory = RuntimeTypeAdapterFactory.of(Shape.class) .registerSubtype(Rectangle.class) .registerSubtype(Circle.class) .registerSubtype(Diamond.class); `
```

### Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun <R : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> create(gson: Gson, type: TypeToken<`[`R`](create.md#R)`>): TypeAdapter<`[`R`](create.md#R)`>` |
| [of](of.md) | `static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](of.md#T)`>, typeFieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, maintainType: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`RuntimeTypeAdapterFactory`](./index.md)`<`[`T`](of.md#T)`>`<br>Creates a new runtime type adapter using for `baseType` using `typeFieldName` as the type field name. Type field names are case sensitive. `maintainType` flag decide if the type will be stored in pojo or not.`static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](of.md#T)`>, typeFieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`RuntimeTypeAdapterFactory`](./index.md)`<`[`T`](of.md#T)`>`<br>Creates a new runtime type adapter using for `baseType` using `typeFieldName` as the type field name. Type field names are case sensitive.`static fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> of(baseType: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<`[`T`](of.md#T)`>): `[`RuntimeTypeAdapterFactory`](./index.md)`<`[`T`](of.md#T)`>`<br>Creates a new runtime type adapter for `baseType` using `"type"` as the type field name. |
| [registerSubtype](register-subtype.md) | `fun registerSubtype(type: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`T`](index.md#T)`>, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`RuntimeTypeAdapterFactory`](./index.md)`<`[`T`](index.md#T)`>`<br>Registers `type` identified by `label`. Labels are case sensitive.`fun registerSubtype(type: `[`Class`](http://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)`<out `[`T`](index.md#T)`>): `[`RuntimeTypeAdapterFactory`](./index.md)`<`[`T`](index.md#T)`>`<br>Registers `type` identified by its ``[`simple`](#). Labels are case sensitive. |
