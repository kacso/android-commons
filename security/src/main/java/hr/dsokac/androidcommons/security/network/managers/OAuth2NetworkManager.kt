package hr.dsokac.androidcommons.security.network.managers

import hr.dsokac.androidcommons.network.interceptors.NetworkExceptionInterceptor
import hr.dsokac.androidcommons.security.network.services.OAuth2Service
import hr.dsokac.androidcommons.security.network.services.RxOAuth2Service
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Class which configures Retrofit service in order to perform
 * authorization requests according to oAuth2 standard
 *
 * @param baseUrl basic part of authorization server URL. For example: https://192.168.112:8080/security/
 * @param connectTimeoutSecs maximum waiting time for connection to establish
 * @param readTimeoutSecs maximum waiting time for server to return response
 *
 * @author Danijel Sokač
 */
class OAuth2NetworkManager(
    private val baseUrl: String,
    private val connectTimeoutSecs: Long,
    private val readTimeoutSecs: Long,
    private val networkExceptionInterceptor: NetworkExceptionInterceptor? = null
) {
    private val httpClient by lazy {
        setupHttpClient()
    }

    private fun setupHttpClient(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()

        networkExceptionInterceptor?.apply {
            httpBuilder.addInterceptor(this)
        }

        val httpLoggingInterceptor = HttpLoggingInterceptor {
            //            log(it)
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpBuilder.addInterceptor(httpLoggingInterceptor)


        httpBuilder.connectTimeout(connectTimeoutSecs, TimeUnit.SECONDS)
            .readTimeout(readTimeoutSecs, TimeUnit.SECONDS)

        return httpBuilder.build()
    }

    private val restBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
    }

    private val rxRestBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
    }

    private val retrofit by lazy {
        restBuilder
            .client(
                httpClient
            )
            .build()
    }

    private val rxRetrofit by lazy {
        rxRestBuilder
            .client(
                httpClient
            )
            .build()
    }

    /**
     * If not initialized already, it will initialize [OAuth2Service] and return it
     *
     * @return [OAuth2Service] which can be used to perform network requests
     */
    val restService: OAuth2Service by lazy {
        retrofit.create(OAuth2Service::class.java)
    }

    /**
     * If not initialized already, it will initialize [RxOAuth2Service] and return it
     *
     * @return [RxOAuth2Service] which can be used to perform network requests
     */
    val rxService: RxOAuth2Service by lazy {
        rxRetrofit.create(RxOAuth2Service::class.java)
    }
}