[security](../../index.md) / [com.github.kacso.androidcommons.security.factories](../index.md) / [SecurityRepositoryFactory](.)

# SecurityRepositoryFactory

`object SecurityRepositoryFactory`

Factory class which generates repositories available in security module

**Author**
Danijel Sokač

### Functions

| Name | Summary |
|---|---|
| [getOAuth2Repository](get-o-auth2-repository.md) | `fun getOAuth2Repository(context: <ERROR CLASS>, baseUrl: String, authorizationKey: String, connectionTimeoutSecs: Long = CONNECT_TIMEOUT_SECS, readTimeoutSecs: Long = READ_TIMEOUT_SECS, networkExceptionInterceptor: <ERROR CLASS>? = null): `[`IOAuth2Repository`](../../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md)<br>Obtain instance of [IOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md). This method will ensure that there is
always only one instance of [IOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md) created for same [baseUrl](get-o-auth2-repository.md#com.github.kacso.androidcommons.security.factories.SecurityRepositoryFactory$getOAuth2Repository(, kotlin.String, kotlin.String, kotlin.Long, kotlin.Long, )/baseUrl). |
| [getRxOAuth2Repository](get-rx-o-auth2-repository.md) | `fun getRxOAuth2Repository(context: <ERROR CLASS>, baseUrl: String, authorizationKey: String, connectionTimeoutSecs: Long = CONNECT_TIMEOUT_SECS, readTimeoutSecs: Long = READ_TIMEOUT_SECS, networkExceptionInterceptor: <ERROR CLASS>? = null): `[`IRxOAuth2Repository`](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md)<br>Obtain instance of [IRxOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md). This method will ensure that there is
always only one instance of [IRxOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md) created. |
