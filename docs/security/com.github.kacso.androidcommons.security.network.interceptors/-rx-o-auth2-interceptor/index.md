[security](../../index.md) / [com.github.kacso.androidcommons.security.network.interceptors](../index.md) / [RxOAuth2Interceptor](./index.md)

# RxOAuth2Interceptor

`class RxOAuth2Interceptor : Interceptor`

Authentication interceptor which handles oAuth2 protocol by intercepting all HTTP outgoing
requests and appending there authorization header with active access token. In case of
expired access token, it will automatically try to refresh token and in case of
successfully refreshed token, proceed with request. In case that new access token can not be
obtained it will throw [Unauthorized](#)

### Parameters

`authRepo` - instance of [IRxOAuth2Repository](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md) to handle fetching and saving tokens

**Author**
Danijel Sokač

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RxOAuth2Interceptor(authRepo: `[`IRxOAuth2Repository`](../../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md)`, unauthorizedCodes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`> = listOf(401, 403))`<br>Authentication interceptor which handles oAuth2 protocol by intercepting all HTTP outgoing requests and appending there authorization header with active access token. In case of expired access token, it will automatically try to refresh token and in case of successfully refreshed token, proceed with request. In case that new access token can not be obtained it will throw [Unauthorized](#) |

### Functions

| Name | Summary |
|---|---|
| [intercept](intercept.md) | `fun intercept(chain: Chain): Response` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [LOG_TAG](-l-o-g_-t-a-g.md) | `const val LOG_TAG: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
