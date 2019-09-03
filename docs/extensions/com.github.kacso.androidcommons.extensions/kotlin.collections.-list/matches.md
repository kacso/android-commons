[extensions](../../index.md) / [com.github.kacso.androidcommons.extensions](../index.md) / [kotlin.collections.List](index.md) / [matches](.)

# matches

`fun List<String?>.matches(query: String?, ignoreCase: Boolean = true): Boolean`

This function will check if any of input key values matches any words in query parameter.
Function is case insensitive.

### Parameters

`this` - list of keys to be searched on

`query` - query on which search should be performed

`ignoreCase` - `true` to ignore character case when comparing strings. By default `true`.

**Example**
keys: listOf("John", "Doe")
query: "John Doe"        query: "Mark doe"       query: "Mark"
result: true            result: true        result: false

**Return**
true if query matches any of keys, false otherwise

