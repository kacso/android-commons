[network](../index.md) / [com.github.kacso.androidcommons.network.exceptions](.)

## Package com.github.kacso.androidcommons.network.exceptions

### Exceptions

| Name | Summary |
|---|---|
| [BadRequest](-bad-request/index.md) | `open class BadRequest : `[`NetworkException`](-network-exception/index.md)<br>An exception which is thrown when server returns Bad request (one of 4xx codes) |
| [NetworkException](-network-exception/index.md) | `abstract class NetworkException : `[`IOException`](http://docs.oracle.com/javase/8/docs/api/java/io/IOException.html)<br>An exception which is thrown when request to server fails |
| [RequestFailedException](-request-failed-exception/index.md) | `open class RequestFailedException : `[`NetworkException`](-network-exception/index.md)<br>An exception which is thrown when server request fails due to connection issues (e.g. no internet service or
timeout occurs) |
| [ServerError](-server-error/index.md) | `open class ServerError : `[`NetworkException`](-network-exception/index.md)<br>An exception which is thrown when server returns Server error (one of 5xx codes) |
| [Unauthorized](-unauthorized/index.md) | `open class Unauthorized : `[`NetworkException`](-network-exception/index.md)<br>An exception which is thrown when server returns Unauthorized (e.g. 401 or 403) |
| [UnexpectedError](-unexpected-error/index.md) | `class UnexpectedError : `[`NetworkException`](-network-exception/index.md)<br>Exception thrown when there has happen some error during network call, but that error does not
belong to any other well known exception |
