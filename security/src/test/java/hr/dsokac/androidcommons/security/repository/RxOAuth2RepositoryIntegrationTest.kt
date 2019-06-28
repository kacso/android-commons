package hr.dsokac.androidcommons.security.repository

import com.google.gson.Gson
import hr.dsokac.androidcommons.network.exceptions.RequestFailedException
import hr.dsokac.androidcommons.network.exceptions.ServerError
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.network.factories.NetworkExceptionFactory
import hr.dsokac.androidcommons.network.interceptors.NetworkExceptionInterceptor
import hr.dsokac.androidcommons.security.factories.SecurityRepositoryFactory
import hr.dsokac.androidcommons.security.network.models.OAuth2LoginResponse
import hr.dsokac.androidcommons.security.repositories.IRxOAuth2Repository
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.concurrent.TimeUnit


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [23])
class RxOAuth2RepositoryIntegrationTest {
    private val ACCESS_TOKEN = "AccessToken"
    private val REFRESH_TOKEN = "RefreshToken"
    private val TOKEN_TYPE = "TokenType"
    private val USERNAME = "Username"
    private val PASSWORD = "Password"
    private val AUTHORIZATION_KEY = "Basic Aycx21312easdxyxyxcyxdcasdfw3"
    private val TIMEOUT = 1L

    private lateinit var repository: IRxOAuth2Repository
    private lateinit var server: MockWebServer

    @Before
    fun setup() {
        server = MockWebServer()
        server.start()

        repository = SecurityRepositoryFactory.getRxOAuth2Repository(
            RuntimeEnvironment.systemContext,
            server.url("/security/").toString(),
            AUTHORIZATION_KEY,
            TIMEOUT,
            TIMEOUT,
            NetworkExceptionInterceptor(NetworkExceptionFactory())
        )
    }

    @After
    fun tearDown() {
        server.shutdown()
        repository.clearSession()
    }

    @Test
    fun session() {
        Assertions.assertNull(repository.getAccessToken())
        Assertions.assertNull(repository.getRefreshToken())
        Assertions.assertNull(repository.getTokenType())
        Assertions.assertNull(repository.getUsername())

        repository.save(ACCESS_TOKEN, REFRESH_TOKEN, TOKEN_TYPE)
        repository.saveUsername(USERNAME)

        Assertions.assertEquals(ACCESS_TOKEN, repository.getAccessToken())
        Assertions.assertEquals(REFRESH_TOKEN, repository.getRefreshToken())
        Assertions.assertEquals(TOKEN_TYPE, repository.getTokenType())
        Assertions.assertEquals(USERNAME, repository.getUsername())

        repository.clearSession()
        Assertions.assertNull(repository.getAccessToken())
        Assertions.assertNull(repository.getRefreshToken())
        Assertions.assertNull(repository.getTokenType())
        Assertions.assertNull(repository.getUsername())
    }

    @Test
    fun successfulLogin() {
        server.enqueue(
            MockResponse().setResponseCode(200).setBody(
                Gson().toJson(
                    OAuth2LoginResponse(
                        accessToken = ACCESS_TOKEN,
                        refreshToken = REFRESH_TOKEN,
                        tokenType = TOKEN_TYPE,
                        expiresIn = 1000
                    )
                )
            )
        )

        repository.login(USERNAME, PASSWORD).blockingAwait()

        Assertions.assertEquals(ACCESS_TOKEN, repository.getAccessToken())
        Assertions.assertEquals(REFRESH_TOKEN, repository.getRefreshToken())
        Assertions.assertEquals(TOKEN_TYPE, repository.getTokenType())
        Assertions.assertEquals(USERNAME, repository.getUsername())

    }

    @Test
    fun failedLoginWrongCredentials() {
        server.enqueue(
            MockResponse().setResponseCode(401)
        )

        val throwable = repository.login(USERNAME, PASSWORD).blockingGet()
        Assertions.assertEquals(Unauthorized::class.java, throwable!!.javaClass)

        Assertions.assertNull(repository.getAccessToken())
        Assertions.assertNull(repository.getRefreshToken())
        Assertions.assertNull(repository.getTokenType())
        Assertions.assertNull(repository.getUsername())
    }

    @Test
    fun failedLoginServerError() {
        server.enqueue(
            MockResponse().setResponseCode(500)
        )

        val throwable = repository.login(USERNAME, PASSWORD).blockingGet()
        Assertions.assertEquals(ServerError::class.java, throwable!!.javaClass)

        Assertions.assertNull(repository.getAccessToken())
        Assertions.assertNull(repository.getRefreshToken())
        Assertions.assertNull(repository.getTokenType())
        Assertions.assertNull(repository.getUsername())
    }

    @Test
    fun failedLoginTimeout() {
        server.enqueue(
            MockResponse().setResponseCode(200).setBody(
                Gson().toJson(
                    OAuth2LoginResponse(
                        accessToken = ACCESS_TOKEN,
                        refreshToken = REFRESH_TOKEN,
                        tokenType = TOKEN_TYPE,
                        expiresIn = 1000
                    )
                )
            ).setBodyDelay(TIMEOUT + 2, TimeUnit.SECONDS)
        )

        val throwable = repository.login(USERNAME, PASSWORD).blockingGet()
        Assertions.assertEquals(RequestFailedException::class.java, throwable!!.javaClass)

        Assertions.assertNull(repository.getAccessToken())
        Assertions.assertNull(repository.getRefreshToken())
        Assertions.assertNull(repository.getTokenType())
        Assertions.assertNull(repository.getUsername())

    }

    @Test
    fun successfulRefreshToken() {
        repository.save(ACCESS_TOKEN, REFRESH_TOKEN, TOKEN_TYPE)
        val newAccessToken = "NewAccess"
        val newRefreshToken = "NewRefresh"
        val newTokenType = "NewType"
        server.enqueue(
            MockResponse().setResponseCode(200).setBody(
                Gson().toJson(
                    OAuth2LoginResponse(
                        accessToken = newAccessToken,
                        refreshToken = newRefreshToken,
                        tokenType = newTokenType,
                        expiresIn = 1000
                    )
                )
            )
        )

        repository.refreshToken().blockingAwait()

        Assertions.assertEquals(newAccessToken, repository.getAccessToken())
        Assertions.assertEquals(newRefreshToken, repository.getRefreshToken())
        Assertions.assertEquals(newTokenType, repository.getTokenType())

    }

    @Test
    fun failedRefreshTokenServerError() {
        repository.save(ACCESS_TOKEN, REFRESH_TOKEN, TOKEN_TYPE)
        server.enqueue(
            MockResponse().setResponseCode(500)
        )

        val throwable = repository.refreshToken().blockingGet()
        Assertions.assertEquals(ServerError::class.java, throwable!!.javaClass)

        Assertions.assertEquals(ACCESS_TOKEN, repository.getAccessToken())
        Assertions.assertEquals(REFRESH_TOKEN, repository.getRefreshToken())
        Assertions.assertEquals(TOKEN_TYPE, repository.getTokenType())

    }

    @Test
    fun successfulLogout() {
        repository.save(ACCESS_TOKEN, REFRESH_TOKEN, TOKEN_TYPE)
        repository.saveUsername(USERNAME)
        server.enqueue(
            MockResponse().setResponseCode(200)
        )

        repository.logout().blockingAwait()

        Assertions.assertNull(repository.getAccessToken())
        Assertions.assertNull(repository.getRefreshToken())
        Assertions.assertNull(repository.getTokenType())
        Assertions.assertNull(repository.getUsername())

    }

    @Test
    fun failedLogoutServerError() {
        repository.save(ACCESS_TOKEN, REFRESH_TOKEN, TOKEN_TYPE)
        repository.saveUsername(USERNAME)
        server.enqueue(
            MockResponse().setResponseCode(500)
        )

        val throwable = repository.logout().blockingGet()
        Assertions.assertEquals(ServerError::class.java, throwable!!.javaClass)

        Assertions.assertEquals(ACCESS_TOKEN, repository.getAccessToken())
        Assertions.assertEquals(REFRESH_TOKEN, repository.getRefreshToken())
        Assertions.assertEquals(TOKEN_TYPE, repository.getTokenType())
        Assertions.assertEquals(USERNAME, repository.getUsername())

    }

    @Test
    fun failedLogoutUnauthorized() {
        repository.save(ACCESS_TOKEN, REFRESH_TOKEN, TOKEN_TYPE)
        repository.saveUsername(USERNAME)
        server.enqueue(
            MockResponse().setResponseCode(401)
        )

        repository.logout().blockingAwait()

        Assertions.assertNull(repository.getAccessToken())
        Assertions.assertNull(repository.getRefreshToken())
        Assertions.assertNull(repository.getTokenType())
        Assertions.assertNull(repository.getUsername())

    }
}