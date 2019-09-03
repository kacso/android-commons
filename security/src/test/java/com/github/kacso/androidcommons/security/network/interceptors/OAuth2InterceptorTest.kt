package com.github.kacso.androidcommons.security.network.interceptors

import com.github.kacso.androidcommons.network.exceptions.BadRequest
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.security.AUTHORIZATION_HEADER
import com.github.kacso.androidcommons.security.repositories.IOAuth2Repository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class OAuth2InterceptorTest {
    private val ACCESS_TOKEN = "AccessToken"
    private val REFRESH_TOKEN = "RefreshToken"
    private val TOKEN_TYPE = "TokenType"

    @Mock
    lateinit var authRepository: IOAuth2Repository
    @Mock
    lateinit var chain: Interceptor.Chain

    lateinit var request: Request
    lateinit var defaultResponse: Response

    lateinit var interceptor: OAuth2Interceptor

    @BeforeEach
    fun setupTests() {
        MockitoAnnotations.initMocks(this)

        interceptor = OAuth2Interceptor(authRepository)

        request = Request.Builder()
            .url("http:\\mocked")
            .build()

        defaultResponse = Response.Builder()
            .request(request)
            .code(200)
            .protocol(Protocol.HTTP_1_1)
            .message("message")
            .build()
    }

    @Test
    fun emptyAccessToken() {
        Mockito.`when`(authRepository.getAccessToken()).thenReturn(null)

        Assertions.assertThrows(Unauthorized::class.java) { interceptor.intercept(chain) }
    }

    @Test
    fun successfulRequest() {
        Mockito.`when`(authRepository.getAccessToken()).thenReturn(ACCESS_TOKEN)
        Mockito.`when`(authRepository.getTokenType()).thenReturn(TOKEN_TYPE)
        Mockito.`when`(chain.request()).thenReturn(request)
        Mockito.`when`(chain.proceed(any())).doAnswer {
            Assertions.assertEquals(
                "$TOKEN_TYPE $ACCESS_TOKEN",
                (it.arguments[0] as Request).header(AUTHORIZATION_HEADER)
            )
            defaultResponse.newBuilder()
                .request(it.arguments[0] as Request)
                .build()
        }

        val response = interceptor.intercept(chain)
        Assertions.assertEquals(200, response.code())
    }

    @Test
    fun unsuccessfulRequest() {
        Mockito.`when`(authRepository.getAccessToken()).thenReturn(ACCESS_TOKEN)
        Mockito.`when`(authRepository.getTokenType()).thenReturn(TOKEN_TYPE)
        Mockito.`when`(chain.request()).thenReturn(request)
        Mockito.`when`(chain.proceed(any())).doAnswer {
            throw BadRequest()
        }

        Assertions.assertThrows(BadRequest::class.java) { interceptor.intercept(chain) }
    }

    @Test
    fun successfulRefreshToken401ErrorSuccessfulRequest() {
        var procceedCounter = 0
        val newAccessToken = ACCESS_TOKEN + "_"

        Mockito.`when`(authRepository.getAccessToken()).doAnswer {
            if (procceedCounter < 1) {
                ACCESS_TOKEN
            } else {
                newAccessToken
            }
        }
        Mockito.`when`(authRepository.getTokenType()).thenReturn(TOKEN_TYPE)
        Mockito.`when`(authRepository.getRefreshToken()).thenReturn(REFRESH_TOKEN)

        Mockito.`when`(chain.request()).thenReturn(request)

        Mockito.`when`(chain.proceed(any())).doAnswer {
            procceedCounter++
            if (procceedCounter < 2) {
                Assertions.assertEquals(
                    "$TOKEN_TYPE $ACCESS_TOKEN",
                    (it.arguments[0] as Request).header(AUTHORIZATION_HEADER)
                )
                defaultResponse.newBuilder()
                    .request(it.arguments[0] as Request)
                    .code(401)
                    .build()

            } else {
                Assertions.assertEquals(
                    "$TOKEN_TYPE $newAccessToken",
                    (it.arguments[0] as Request).header(AUTHORIZATION_HEADER)
                )
                defaultResponse.newBuilder()
                    .request(it.arguments[0] as Request)
                    .code(200)
                    .build()
            }
        }

        val response = interceptor.intercept(chain)
        Assertions.assertEquals(200, response.code())
        verify(chain, times(2)).proceed(any())
    }

    @Test
    fun successfulRefreshToken403ErrorSuccessfulRequest() {
        var proceedCounter = 0
        val newAccessToken = ACCESS_TOKEN + "_"

        Mockito.`when`(authRepository.getAccessToken()).doAnswer {
            if (proceedCounter < 1) {
                ACCESS_TOKEN
            } else {
                newAccessToken
            }
        }
        Mockito.`when`(authRepository.getTokenType()).thenReturn(TOKEN_TYPE)
        Mockito.`when`(authRepository.getRefreshToken()).thenReturn(REFRESH_TOKEN)

        Mockito.`when`(chain.request()).thenReturn(request)

        Mockito.`when`(chain.proceed(any())).doAnswer {
            proceedCounter++
            if (proceedCounter < 2) {
                Assertions.assertEquals(
                    "$TOKEN_TYPE $ACCESS_TOKEN",
                    (it.arguments[0] as Request).header(AUTHORIZATION_HEADER)
                )
                defaultResponse.newBuilder()
                    .request(it.arguments[0] as Request)
                    .code(403)
                    .build()

            } else {
                Assertions.assertEquals(
                    "$TOKEN_TYPE $newAccessToken",
                    (it.arguments[0] as Request).header(AUTHORIZATION_HEADER)
                )
                defaultResponse.newBuilder()
                    .request(it.arguments[0] as Request)
                    .code(200)
                    .build()
            }
        }

        val response = interceptor.intercept(chain)
        Assertions.assertEquals(200, response.code())
        verify(chain, times(2)).proceed(any())
    }

    @Test
    fun emptyRefreshToken() {
        Mockito.`when`(authRepository.getAccessToken()).thenReturn(ACCESS_TOKEN)
        Mockito.`when`(authRepository.getTokenType()).thenReturn(TOKEN_TYPE)
        Mockito.`when`(authRepository.getRefreshToken()).thenReturn("")

        Mockito.`when`(chain.request()).thenReturn(request)

        Mockito.`when`(chain.proceed(any())).doAnswer {
            Assertions.assertEquals(
                "$TOKEN_TYPE $ACCESS_TOKEN",
                (it.arguments[0] as Request).header(AUTHORIZATION_HEADER)
            )
            defaultResponse.newBuilder()
                .request(it.arguments[0] as Request)
                .code(401)
                .build()
        }

        Assertions.assertThrows(Unauthorized::class.java) { interceptor.intercept(chain) }
        verify(chain, times(1)).proceed(any())
    }

    @Test
    fun unsuccessfulRefreshToken() {
        Mockito.`when`(authRepository.getAccessToken()).thenReturn(ACCESS_TOKEN)
        Mockito.`when`(authRepository.getTokenType()).thenReturn(TOKEN_TYPE)
        Mockito.`when`(authRepository.getRefreshToken()).thenReturn(REFRESH_TOKEN)
        runBlocking {
            Mockito.`when`(authRepository.refreshToken()).then { throw BadRequest() }
        }

        Mockito.`when`(chain.request()).thenReturn(request)

        Mockito.`when`(chain.proceed(any())).doAnswer {
            Assertions.assertEquals(
                "$TOKEN_TYPE $ACCESS_TOKEN",
                (it.arguments[0] as Request).header(AUTHORIZATION_HEADER)
            )
            defaultResponse.newBuilder()
                .request(it.arguments[0] as Request)
                .code(401)
                .build()
        }

        Assertions.assertThrows(Unauthorized::class.java) { interceptor.intercept(chain) }
        verify(chain, times(1)).proceed(any())
    }
}