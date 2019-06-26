package hr.dsokac.androidcommons.network.interceptors

import com.nhaarman.mockitokotlin2.any
import hr.dsokac.androidcommons.network.exceptions.BadRequest
import hr.dsokac.androidcommons.network.exceptions.RequestFailedException
import hr.dsokac.androidcommons.network.factories.NetworkExceptionFactory
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.io.IOException

class NetworkExceptionInterceptorTest {
    @Mock
    lateinit var chain: Interceptor.Chain

    @Mock
    lateinit var request: Request

    @Mock
    lateinit var response: Response

    private val interceptor = NetworkExceptionInterceptor(NetworkExceptionFactory())

    @BeforeEach
    fun setupTest() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(chain.request()).then { request }
        Mockito.`when`(response.body()).then { ResponseBody.create(null, "") }
    }

    @Test
    fun successfulRequest() {
        Mockito.`when`(response.code()).then { 200 }
        Mockito.`when`(response.isSuccessful).then { true }
        Mockito.`when`(chain.proceed(any())).then { response }
        val r = interceptor.intercept(chain)

        Assertions.assertEquals(response, r)
    }

    @Test
    fun requestFailed() {
        Mockito.`when`(chain.proceed(any())).then { throw IOException() }

        Assertions.assertThrows(RequestFailedException::class.java) { interceptor.intercept(chain) }
    }

    @Test
    fun badRequest() {
        Mockito.`when`(response.code()).then { 404 }
        Mockito.`when`(response.isSuccessful).then { false }
        Mockito.`when`(chain.proceed(any())).then { response }

        Assertions.assertThrows(BadRequest::class.java) { interceptor.intercept(chain) }
    }

}