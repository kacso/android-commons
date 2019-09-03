[security](../../index.md) / [com.github.kacso.androidcommons.security.factories](../index.md) / [SecurityRepositoryFactory](index.md) / [getOAuth2Repository](.)

# getOAuth2Repository

`fun getOAuth2Repository(context: <ERROR CLASS>, baseUrl: String, authorizationKey: String, connectionTimeoutSecs: Long = CONNECT_TIMEOUT_SECS, readTimeoutSecs: Long = READ_TIMEOUT_SECS, networkExceptionInterceptor: <ERROR CLASS>? = null): `[`IOAuth2Repository`](../../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md)

Obtain instance of [IOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md). This method will ensure that there is
always only one instance of [IOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md) created for same [baseUrl](get-o-auth2-repository.md#com.github.kacso.androidcommons.security.factories.SecurityRepositoryFactory$getOAuth2Repository(, kotlin.String, kotlin.String, kotlin.Long, kotlin.Long, )/baseUrl).

### Parameters

`baseUrl` - basic part of authorization server URL. For example: https://192.168.112:8080/security/

`authorizationKey` - key which will identify app requests on authorization server
For example: Basic Aycx21312easdxyxyxcyxdcasdfw3

`connectionTimeoutSecs` - maximum waiting time for connection to establish

`readTimeoutSecs` - maximum waiting time for server to return response

`networkExceptionInterceptor` - instance of [NetworkExceptionInterceptor](#) which will convert errors, or null
if such interceptor is not needed

**Return**
instance of [IOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md)

