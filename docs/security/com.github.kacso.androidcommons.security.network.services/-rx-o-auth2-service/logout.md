[security](../../index.md) / [com.github.kacso.androidcommons.security.network.services](../index.md) / [RxOAuth2Service](index.md) / [logout](.)

# logout

`abstract fun logout(token: String): <ERROR CLASS><<ERROR CLASS>>`

Performs logout of authorized user.

### Parameters

`token` - active access token

**Return**
emits [ResponseBody](#) or [NetworkException](#) in cas of an error through [Single](#)

