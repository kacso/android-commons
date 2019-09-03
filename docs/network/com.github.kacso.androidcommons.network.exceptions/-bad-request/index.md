[network](../../index.md) / [com.github.kacso.androidcommons.network.exceptions](../index.md) / [BadRequest](.)

# BadRequest

`open class BadRequest : `[`NetworkException`](../-network-exception/index.md)

An exception which is thrown when server returns Bad request (one of 4xx codes)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BadRequest(httpException: <ERROR CLASS>? = null)`<br>An exception which is thrown when server returns Bad request (one of 4xx codes) |

### Properties

| Name | Summary |
|---|---|
| [httpException](http-exception.md) | `val httpException: <ERROR CLASS>?`<br>instance of [HttpException](#) which contains more info about exception or null if http
exception is not available |

### Inherited Properties

| Name | Summary |
|---|---|
| [response](../-network-exception/response.md) | `val response: <ERROR CLASS><out <ERROR CLASS>>?`<br>response returned from server if exist |
