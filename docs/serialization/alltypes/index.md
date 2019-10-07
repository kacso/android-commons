

### All Types

| Name | Summary |
|---|---|
| [com.github.kacso.androidcommons.serialization.typeadapters.DurationTypeAdapter](../com.github.kacso.androidcommons.serialization.typeadapters/-duration-type-adapter/index.md) |  |
| [com.google.gson.GsonBuilder](../com.github.kacso.androidcommons.serialization.extensions/com.google.gson.-gson-builder/index.md) (extensions in package com.github.kacso.androidcommons.serialization.extensions) |  |
| [com.github.kacso.androidcommons.serialization.typeadapters.InstantTypeAdapter](../com.github.kacso.androidcommons.serialization.typeadapters/-instant-type-adapter/index.md) |  |
| [com.github.kacso.androidcommons.serialization.typeadapters.LocalDateTimeTypeAdapter](../com.github.kacso.androidcommons.serialization.typeadapters/-local-date-time-type-adapter/index.md) |  |
| [com.github.kacso.androidcommons.serialization.typeadapters.LocalDateTypeAdapter](../com.github.kacso.androidcommons.serialization.typeadapters/-local-date-type-adapter/index.md) |  |
| [com.github.kacso.androidcommons.serialization.typeadapters.LocalTimeTypeAdapter](../com.github.kacso.androidcommons.serialization.typeadapters/-local-time-type-adapter/index.md) |  |
| [com.github.kacso.androidcommons.serialization.factories.RuntimeTypeAdapterFactory](../com.github.kacso.androidcommons.serialization.factories/-runtime-type-adapter-factory/index.md) | Adapts values whose runtime type may differ from their declaration type. This is necessary when a field's type is not the same type that GSON should create when deserializing that field. For example, consider these types:

```
`abstract class Shape { int x; int y; } class Circle extends Shape { int radius; } class Rectangle extends Shape { int width; int height; } class Diamond extends Shape { int width; int height; } class Drawing { Shape bottomShape; Shape topShape; } `<br>```
<br> <br>Without additional type information, the serialized JSON is ambiguous. Is the bottom shape in this drawing a rectangle or a diamond?

```
`{ "bottomShape": { "width": 10, "height": 5, "x": 0, "y": 0 }, "topShape": { "radius": 2, "x": 4, "y": 1 } }`<br>```
<br> This class addresses this problem by adding type information to the serialized JSON and honoring that type information when the JSON is deserialized:

```
`{ "bottomShape": { "type": "Diamond", "width": 10, "height": 5, "x": 0, "y": 0 }, "topShape": { "type": "Circle", "radius": 2, "x": 4, "y": 1 } }`<br>```
<br> Both the type field name (`"type"`) and the type labels (`"Rectangle"`) are configurable. Registering Types Create a `RuntimeTypeAdapterFactory` by passing the base type and type field name to the ``[`#of`](#) factory method. If you don't supply an explicit type field name, `"type"` will be used.

```
`RuntimeTypeAdapterFactory<Shape> shapeAdapterFactory = RuntimeTypeAdapterFactory.of(Shape.class, "type"); `<br>```
<br> Next register all of your subtypes. Every subtype must be explicitly registered. This protects your application from injection attacks. If you don't supply an explicit type label, the type's simple name will be used.

```
`shapeAdapterFactory.registerSubtype(Rectangle.class, "Rectangle"); shapeAdapterFactory.registerSubtype(Circle.class, "Circle"); shapeAdapterFactory.registerSubtype(Diamond.class, "Diamond"); `<br>```
<br> Finally, register the type adapter factory in your application's GSON builder:

```
`Gson gson = new GsonBuilder() .registerTypeAdapterFactory(shapeAdapterFactory) .create(); `<br>```
<br> Like `GsonBuilder`, this API supports chaining:

```
`RuntimeTypeAdapterFactory<Shape> shapeAdapterFactory = RuntimeTypeAdapterFactory.of(Shape.class) .registerSubtype(Rectangle.class) .registerSubtype(Circle.class) .registerSubtype(Diamond.class); `<br>```
<br> |
| [com.github.kacso.androidcommons.serialization.typeadapters.ZonedDateTimeTypeAdapter](../com.github.kacso.androidcommons.serialization.typeadapters/-zoned-date-time-type-adapter/index.md) |  |
