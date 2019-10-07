[network](../../index.md) / [com.github.kacso.androidcommons.network.exceptions](../index.md) / [Unauthorized](./index.md)

# Unauthorized

`open class Unauthorized : `[`NetworkException`](../-network-exception/index.md)

An exception which is thrown when server returns Unauthorized (e.g. 401 or 403)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Unauthorized(httpException: HttpException? = null)`<br>An exception which is thrown when server returns Unauthorized (e.g. 401 or 403) |

### Properties

| Name | Summary |
|---|---|
| [httpException](http-exception.md) | `val httpException: HttpException?`<br>instance of [HttpException](#) which contains more info about exception or null if http     exception is not available |

### Inherited Properties

| Name | Summary |
|---|---|
| [response](../-network-exception/response.md) | `val response: Response<*>?`<br>response returned from server if exist |
