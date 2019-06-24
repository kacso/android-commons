package hr.dsokac.androidcommons.network.managers

import com.google.gson.GsonBuilder
import hr.dsokac.androidcommons.network.factories.NetworkExceptionFactory
import hr.dsokac.androidcommons.network.interceptors.NetworkExceptionInterceptor
import hr.dsokac.androidcommons.network.services.AppService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppNetworkManager {
    private val httpClient by lazy {
        setupHttpClient()
    }

    private fun setupHttpClient(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpBuilder.addInterceptor(httpLoggingInterceptor)

        httpBuilder.addInterceptor(NetworkExceptionInterceptor(NetworkExceptionFactory()))

        httpBuilder.connectTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(10L, TimeUnit.SECONDS)

        return httpBuilder.build()
    }

    private val restBuilder by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(
                GsonConverterFactory.create(gson)
            )
    }

    private val gson = GsonBuilder()
//        .registerJavaTimeTypeAdapters()
        .create()

    private val retrofit by lazy {
        restBuilder
            .client(
                httpClient
            )
            .build()
    }

    private val restService by lazy {
        retrofit.create(AppService::class.java)
    }

    /**
     * If not initialized already, it will initialize AppService and return it
     *
     * @return [AppService] which can be used to perform network requests
     */
    fun getService(): AppService {
        return restService
    }
}