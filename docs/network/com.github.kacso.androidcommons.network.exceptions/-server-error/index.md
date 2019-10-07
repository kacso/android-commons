[network](../../index.md) / [com.github.kacso.androidcommons.network.exceptions](../index.md) / [ServerError](./index.md)

# ServerError

`open class ServerError : `[`NetworkException`](../-network-exception/index.md)

An exception which is thrown when server returns Server error (one of 5xx codes)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ServerError(httpException: HttpException? = null)`<br>An exception which is thrown when server returns Server error (one of 5xx codes) |

### Properties

| Name | Summary |
|---|---|
| [httpException](http-exception.md) | `val httpException: HttpException?`<br>instance of [HttpException](#) which contains more info about exception or null if http     exception is not available |

### Inherited Properties

| Name | Summary |
|---|---|
| [response](../-network-exception/response.md) | `val response: Response<*>?`<br>response returned from server if exist |
