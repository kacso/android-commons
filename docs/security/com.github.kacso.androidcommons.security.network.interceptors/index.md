[security](../index.md) / [com.github.kacso.androidcommons.security.network.interceptors](./index.md)

## Package com.github.kacso.androidcommons.security.network.interceptors

### Types

| Name | Summary |
|---|---|
| [OAuth2Interceptor](-o-auth2-interceptor/index.md) | `class OAuth2Interceptor : Interceptor`<br>Authentication interceptor which handles oAuth2 protocol by intercepting all HTTP outgoing requests and appending there authorization header with active access token. In case of expired access token, it will automatically try to refresh token and in case of successfully refreshed token, proceed with request. In case that new access token can not be obtained it will throw [Unauthorized](#) |
| [RxOAuth2Interceptor](-rx-o-auth2-interceptor/index.md) | `class RxOAuth2Interceptor : Interceptor`<br>Authentication interceptor which handles oAuth2 protocol by intercepting all HTTP outgoing requests and appending there authorization header with active access token. In case of expired access token, it will automatically try to refresh token and in case of successfully refreshed token, proceed with request. In case that new access token can not be obtained it will throw [Unauthorized](#) |
