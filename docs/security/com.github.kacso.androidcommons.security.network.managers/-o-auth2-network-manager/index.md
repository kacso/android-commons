[security](../../index.md) / [com.github.kacso.androidcommons.security.network.managers](../index.md) / [OAuth2NetworkManager](.)

# OAuth2NetworkManager

`class OAuth2NetworkManager`

Class which configures Retrofit service in order to perform
authorization requests according to oAuth2 standard

### Parameters

`baseUrl` - basic part of authorization server URL. For example: https://192.168.112:8080/security/

`connectTimeoutSecs` - maximum waiting time for connection to establish

`readTimeoutSecs` - maximum waiting time for server to return response

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OAuth2NetworkManager(baseUrl: String, connectTimeoutSecs: Long, readTimeoutSecs: Long, networkExceptionInterceptor: <ERROR CLASS>? = null)`<br>Class which configures Retrofit service in order to perform
authorization requests according to oAuth2 standard |

### Properties

| Name | Summary |
|---|---|
| [restService](rest-service.md) | `val restService: `[`OAuth2Service`](../../com.github.kacso.androidcommons.security.network.services/-o-auth2-service/index.md)<br>If not initialized already, it will initialize [OAuth2Service](../../com.github.kacso.androidcommons.security.network.services/-o-auth2-service/index.md) and return it |
| [rxService](rx-service.md) | `val rxService: `[`RxOAuth2Service`](../../com.github.kacso.androidcommons.security.network.services/-rx-o-auth2-service/index.md)<br>If not initialized already, it will initialize [RxOAuth2Service](../../com.github.kacso.androidcommons.security.network.services/-rx-o-auth2-service/index.md) and return it |
