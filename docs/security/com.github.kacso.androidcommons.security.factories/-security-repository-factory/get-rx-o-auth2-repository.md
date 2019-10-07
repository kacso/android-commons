[security](../../index.md) / [com.github.kacso.androidcommons.security.factories](../index.md) / [SecurityRepositoryFactory](index.md) / [getRxOAuth2Repository](./get-rx-o-auth2-repository.md)

# getRxOAuth2Repository

`@Synchronized fun getRxOAuth2Repository(context: Context, baseUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, authorizationKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, connectionTimeoutSecs: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = CONNECT_TIMEOUT_SECS, readTimeoutSecs: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = READ_TIMEOUT_SECS, networkExceptionInterceptor: NetworkExceptionInterceptor? = null): `[`IRxOAuth2Repository`](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md)

Obtain instance of [IRxOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md). This method will ensure that there is
always only one instance of [IRxOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md) created.

### Parameters

`baseUrl` - basic part of authorization server URL. For example: https://192.168.112:8080/security/

`authorizationKey` - key which will identify app requests on authorization server
    For example: Basic Aycx21312easdxyxyxcyxdcasdfw3

`connectionTimeoutSecs` - maximum waiting time for connection to establish

`readTimeoutSecs` - maximum waiting time for server to return response

`networkExceptionInterceptor` - instance of [NetworkExceptionInterceptor](#) which will convert errors, or null
    if such interceptor is not needed

**Return**
instance of [IRxOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md)

