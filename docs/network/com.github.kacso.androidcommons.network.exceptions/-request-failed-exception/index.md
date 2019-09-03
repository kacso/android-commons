[network](../../index.md) / [com.github.kacso.androidcommons.network.exceptions](../index.md) / [RequestFailedException](.)

# RequestFailedException

`open class RequestFailedException : `[`NetworkException`](../-network-exception/index.md)

An exception which is thrown when server request fails due to connection issues (e.g. no internet service or
timeout occurs)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RequestFailedException(ioException: `[`IOException`](http://docs.oracle.com/javase/8/docs/api/java/io/IOException.html)`? = null)`<br>An exception which is thrown when server request fails due to connection issues (e.g. no internet service or
timeout occurs) |

### Properties

| Name | Summary |
|---|---|
| [ioException](io-exception.md) | `val ioException: `[`IOException`](http://docs.oracle.com/javase/8/docs/api/java/io/IOException.html)`?`<br>instance of [IOException](http://docs.oracle.com/javase/8/docs/api/java/io/IOException.html) which contains more info about exception or null if http
exception is not available |

### Inherited Properties

| Name | Summary |
|---|---|
| [response](../-network-exception/response.md) | `val response: <ERROR CLASS><out <ERROR CLASS>>?`<br>response returned from server if exist |
