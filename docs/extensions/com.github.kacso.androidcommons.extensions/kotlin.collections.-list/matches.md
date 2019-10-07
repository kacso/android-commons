[extensions](../../index.md) / [com.github.kacso.androidcommons.extensions](../index.md) / [kotlin.collections.List](index.md) / [matches](./matches.md)

# matches

`fun `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>.matches(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, ignoreCase: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

This function will check if any of input key values matches any words in query parameter.
Function is case insensitive.

### Parameters

`this` - list of keys to be searched on

`query` - query on which search should be performed

`ignoreCase` - `true` to ignore character case when comparing strings. By default `true`.

**Example**

```
    keys: listOf("John", "Doe")
    query: "John Doe"        query: "Mark doe"       query: "Mark"
    result: true            result: true        result: false
```

**Return**
true if query matches any of keys, false otherwise

