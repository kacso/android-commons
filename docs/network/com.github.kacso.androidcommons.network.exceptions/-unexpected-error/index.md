[network](../../index.md) / [com.github.kacso.androidcommons.network.exceptions](../index.md) / [UnexpectedError](./index.md)

# UnexpectedError

`class UnexpectedError : `[`NetworkException`](../-network-exception/index.md)

Exception thrown when there has happen some error during network call, but that error does not
belong to any other well known exception

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UnexpectedError(cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null)`<br>Exception thrown when there has happen some error during network call, but that error does not belong to any other well known exception |

### Inherited Properties

| Name | Summary |
|---|---|
| [response](../-network-exception/response.md) | `val response: Response<*>?`<br>response returned from server if exist |
