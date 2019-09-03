package com.github.kacso.androidcommons.network.factories

import com.github.kacso.androidcommons.network.exceptions.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class NetworkExceptionFactoryTest {
    @Mock
    lateinit var response: Response<*>

    val factory = NetworkExceptionFactory()

    @BeforeEach
    fun beforeEach() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun fromHttpCodeUnauthorized() {
        Mockito.`when`(response.code()).then { 401 }
        Assertions.assertThrows(Unauthorized::class.java) { throw factory.fromHttpResponse(response) }

        Mockito.`when`(response.code()).then { 403 }
        Assertions.assertThrows(Unauthorized::class.java) { throw factory.fromHttpResponse(response) }
    }

    @Test
    fun fromHttpCodeBadRequest() {
        val codes = (400..499).toMutableList()
        codes.remove(401)
        codes.remove(403)

        codes.forEach { code ->
            Mockito.`when`(response.code()).then { code }
            Assertions.assertThrows(
                BadRequest::class.java,
                { throw factory.fromHttpResponse(response) },
                "Failed for $code"
            )
        }
    }

    @Test
    fun fromHttpCodeServerError() {
        val codes = (500..599).toList()

        codes.forEach { code ->
            Mockito.`when`(response.code()).then { code }
            Assertions.assertThrows(
                ServerError::class.java,
                { throw factory.fromHttpResponse(response) },
                "Failed for $code"
            )
        }
    }


    @Test
    fun fromHttpCodeUnexpected() {
        Mockito.`when`(response.code()).then { 301 }
        Assertions.assertThrows(UnexpectedError::class.java) { throw factory.fromHttpResponse(response) }
    }

    @Test
    fun fromThrowableUnauthorized() {
        Mockito.`when`(response.code()).then { 401 }
        Assertions.assertThrows(Unauthorized::class.java) { throw factory.toNetworkException(HttpException(response)) }

        Mockito.`when`(response.code()).then { 403 }
        Assertions.assertThrows(Unauthorized::class.java) { throw factory.toNetworkException(HttpException(response)) }
    }

    @Test
    fun fromThrowableBadRequest() {
        val codes = (400..499).toMutableList()
        codes.remove(401)
        codes.remove(403)

        codes.forEach { code ->
            Mockito.`when`(response.code()).then { code }
            Assertions.assertThrows(
                BadRequest::class.java,
                { throw factory.toNetworkException(HttpException(response)) },
                "Failed for $code"
            )
        }
    }

    @Test
    fun fromThrowableServerError() {
        val codes = (500..599).toList()

        codes.forEach { code ->
            Mockito.`when`(response.code()).then { code }
            Assertions.assertThrows(
                ServerError::class.java,
                { throw factory.toNetworkException(HttpException(response)) },
                "Failed for $code"
            )
        }
    }


    @Test
    fun fromThrowableUnexpected() {
        Mockito.`when`(response.code()).then { 301 }
        Assertions.assertThrows(UnexpectedError::class.java) { throw factory.toNetworkException(HttpException(response)) }
    }

    @Test
    fun fromThrowableRequestFailed() {
        Assertions.assertThrows(RequestFailedException::class.java) { throw factory.toNetworkException(IOException()) }
    }

    @Test
    fun fromNetworkException() {
        val e = BadRequest()
        Assertions.assertEquals(e, factory.toNetworkException(e))
    }
}