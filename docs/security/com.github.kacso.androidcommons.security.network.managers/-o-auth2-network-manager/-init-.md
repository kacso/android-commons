[security](../../index.md) / [com.github.kacso.androidcommons.security.network.managers](../index.md) / [OAuth2NetworkManager](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`OAuth2NetworkManager(baseUrl: String, connectTimeoutSecs: Long, readTimeoutSecs: Long, networkExceptionInterceptor: <ERROR CLASS>? = null)`

Class which configures Retrofit service in order to perform
authorization requests according to oAuth2 standard

### Parameters

`baseUrl` - basic part of authorization server URL. For example: https://192.168.112:8080/security/

`connectTimeoutSecs` - maximum waiting time for connection to establish

`readTimeoutSecs` - maximum waiting time for server to return response

**Author**
Danijel Sokač

