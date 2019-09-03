package com.github.kacso.androidcommons.network.calladapters

import com.github.kacso.androidcommons.network.exceptions.BadRequest
import com.github.kacso.androidcommons.network.exceptions.RequestFailedException
import com.github.kacso.androidcommons.network.exceptions.ServerError
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory
import com.github.kacso.androidcommons.network.models.ApiEmptyResponse
import com.github.kacso.androidcommons.network.models.ApiErrorResponse
import com.github.kacso.androidcommons.network.models.ApiSuccessResponse
import com.github.kacso.androidcommons.test.extensions.InstantTaskExecutorExtension
import com.github.kacso.androidcommons.test.lifecycle.getTestValue
import com.github.kacso.androidcommons.test.lifecycle.test
import com.github.kacso.androidcommons.test.models.Foo
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@ExtendWith(InstantTaskExecutorExtension::class)
class LiveDataCallAdapterTest {
    companion object {
        const val TIMEOUT = 1L
        const val CONTENT_LENGTH_HEADER = "Content-Length"
    }

    private val networkExceptionFactory = NetworkExceptionFactory()

    private val service: LiveDataCallAdapterService by lazy {
        configureNetworkService()
    }

    private lateinit var url: String
    private lateinit var server: MockWebServer

    @BeforeEach
    fun setup() {
        server = MockWebServer()
        server.start()
        url = server.url("").toString()
    }

    @AfterEach
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun successfulResponse() {
        val networkResponse = Foo(1)
        val headerName = "Name"
        val headerValue = "Value"
        val jsonResponse = Gson().toJson(networkResponse)
        server.enqueue(
            MockResponse().setResponseCode(200)
                .setBody(jsonResponse)
                .setHeader(headerName, headerValue)
        )

        service.getData().test(
            ApiSuccessResponse(
                networkResponse,
                mapOf(Pair(headerName, headerValue), Pair(CONTENT_LENGTH_HEADER, jsonResponse.length.toString()))
            )
        )
    }

    @Test
    fun noContent() {
        server.enqueue(
            MockResponse().setResponseCode(204)
        )

        service.getData().test(ApiEmptyResponse())
    }

    @Test
    fun badRequestResponse() {
        server.enqueue(
            MockResponse().setResponseCode(400)
        )

        val actual = service.getData().getTestValue()
        Assertions.assertTrue(actual is ApiErrorResponse, "Expected ApiErrorResponse but was $actual")
        Assertions.assertTrue((actual as ApiErrorResponse).error is BadRequest, "Expected BadRequest but was $actual")
    }

    @Test
    fun serverErrorResponse() {
        server.enqueue(
            MockResponse().setResponseCode(500)
        )

        val actual = service.getData().getTestValue()
        Assertions.assertTrue(actual is ApiErrorResponse, "Expected ApiErrorResponse but was $actual")
        Assertions.assertTrue((actual as ApiErrorResponse).error is ServerError, "Expected ServerError but was $actual")
    }

    @Test
    fun unauthorizedResponse() {
        server.enqueue(
            MockResponse().setResponseCode(401)
        )

        val actual = service.getData().getTestValue()
        Assertions.assertTrue(actual is ApiErrorResponse, "Expected ApiErrorResponse but was $actual")
        Assertions.assertTrue(
            (actual as ApiErrorResponse).error is Unauthorized,
            "Expected Unauthorized but was $actual"
        )
    }

    @Test
    fun timeoutResponse() {
        server.enqueue(
            MockResponse().setResponseCode(200)
                .setBody(Gson().toJson(Foo(1)))
                .setBodyDelay(TIMEOUT + 1, TimeUnit.SECONDS)
        )

        val actual = service.getData().getTestValue()
        Assertions.assertTrue(actual is ApiErrorResponse, "Expected ApiErrorResponse but was $actual")
        Assertions.assertTrue(
            (actual as ApiErrorResponse).error is RequestFailedException,
            "Expected RequestFailedException but was $actual"
        )
    }

    private fun configureNetworkService(): LiveDataCallAdapterService {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory(networkExceptionFactory))
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                    .build()
            )
            .build()
            .create(LiveDataCallAdapterService::class.java)
    }
}