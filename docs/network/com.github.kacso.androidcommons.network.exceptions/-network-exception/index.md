[network](../../index.md) / [com.github.kacso.androidcommons.network.exceptions](../index.md) / [NetworkException](./index.md)

# NetworkException

`abstract class NetworkException : `[`IOException`](http://docs.oracle.com/javase/8/docs/api/java/io/IOException.html)

An exception which is thrown when request to server fails

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkException(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, response: Response<*>?, cause: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?)`<br>An exception which is thrown when request to server fails |

### Properties

| Name | Summary |
|---|---|
| [response](response.md) | `val response: Response<*>?`<br>response returned from server if exist |

### Inheritors

| Name | Summary |
|---|---|
| [BadRequest](../-bad-request/index.md) | `open class BadRequest : `[`NetworkException`](./index.md)<br>An exception which is thrown when server returns Bad request (one of 4xx codes) |
| [RequestFailedException](../-request-failed-exception/index.md) | `open class RequestFailedException : `[`NetworkException`](./index.md)<br>An exception which is thrown when server request fails due to connection issues (e.g. no internet service or timeout occurs) |
| [ServerError](../-server-error/index.md) | `open class ServerError : `[`NetworkException`](./index.md)<br>An exception which is thrown when server returns Server error (one of 5xx codes) |
| [Unauthorized](../-unauthorized/index.md) | `open class Unauthorized : `[`NetworkException`](./index.md)<br>An exception which is thrown when server returns Unauthorized (e.g. 401 or 403) |
| [UnexpectedError](../-unexpected-error/index.md) | `class UnexpectedError : `[`NetworkException`](./index.md)<br>Exception thrown when there has happen some error during network call, but that error does not belong to any other well known exception |
