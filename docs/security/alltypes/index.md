

### All Types

| Name | Summary |
|---|---|
| [com.github.kacso.androidcommons.security.BuildConfig](../com.github.kacso.androidcommons.security/-build-config/index.md) |  |
| [com.github.kacso.androidcommons.security.BuildConfig](../com.github.kacso.androidcommons.security/-build-config/index.md) |  |
| [com.github.kacso.androidcommons.security.repositories.IOAuth2Repository](../com.github.kacso.androidcommons.security.repositories/-i-o-auth2-repository/index.md) | Interface defining functionalities which subclasses need to implement in order to handle oAuth2 authorization and other authorization information |
| [com.github.kacso.androidcommons.security.repositories.IRxOAuth2Repository](../com.github.kacso.androidcommons.security.repositories/-i-rx-o-auth2-repository/index.md) | Interface defining functionalities which subclasses need to implement in order to handle oAuth2 authorization and other authorization information |
| [com.github.kacso.androidcommons.security.network.interceptors.OAuth2Interceptor](../com.github.kacso.androidcommons.security.network.interceptors/-o-auth2-interceptor/index.md) | Authentication interceptor which handles oAuth2 protocol by intercepting all HTTP outgoing requests and appending there authorization header with active access token. In case of expired access token, it will automatically try to refresh token and in case of successfully refreshed token, proceed with request. In case that new access token can not be obtained it will throw [Unauthorized](#) |
| [com.github.kacso.androidcommons.security.network.models.OAuth2LoginResponse](../com.github.kacso.androidcommons.security.network.models/-o-auth2-login-response/index.md) | Data model of login response defined by oAuth2 standard |
| [com.github.kacso.androidcommons.security.network.managers.OAuth2NetworkManager](../com.github.kacso.androidcommons.security.network.managers/-o-auth2-network-manager/index.md) | Class which configures Retrofit service in order to perform authorization requests according to oAuth2 standard |
| [com.github.kacso.androidcommons.security.repositories.impl.OAuth2Repository](../com.github.kacso.androidcommons.security.repositories.impl/-o-auth2-repository/index.md) |  |
| [com.github.kacso.androidcommons.security.network.services.OAuth2Service](../com.github.kacso.androidcommons.security.network.services/-o-auth2-service/index.md) | Network service which handles user authorization requests |
| [com.github.kacso.androidcommons.security.network.interceptors.RxOAuth2Interceptor](../com.github.kacso.androidcommons.security.network.interceptors/-rx-o-auth2-interceptor/index.md) | Authentication interceptor which handles oAuth2 protocol by intercepting all HTTP outgoing requests and appending there authorization header with active access token. In case of expired access token, it will automatically try to refresh token and in case of successfully refreshed token, proceed with request. In case that new access token can not be obtained it will throw [Unauthorized](#) |
| [com.github.kacso.androidcommons.security.repositories.impl.RxOAuth2Repository](../com.github.kacso.androidcommons.security.repositories.impl/-rx-o-auth2-repository/index.md) |  |
| [com.github.kacso.androidcommons.security.network.services.RxOAuth2Service](../com.github.kacso.androidcommons.security.network.services/-rx-o-auth2-service/index.md) | Network service which handles user authorization requests |
| [com.github.kacso.androidcommons.security.factories.SecurityRepositoryFactory](../com.github.kacso.androidcommons.security.factories/-security-repository-factory/index.md) | Factory class which generates repositories available in security module |
