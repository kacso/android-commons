package com.github.kacso.androidcommons.network.managers

import com.github.kacso.androidcommons.core.BaseApplication
import com.github.kacso.androidcommons.network.calladapters.LiveDataCallAdapterFactory
import com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory
import com.github.kacso.androidcommons.network.interceptors.NetworkExceptionInterceptor
import com.github.kacso.androidcommons.network.services.AppService
import com.github.kacso.androidcommons.security.factories.SecurityRepositoryFactory
import com.github.kacso.androidcommons.security.network.interceptors.OAuth2Interceptor
import com.github.kacso.androidcommons.serialization.extensions.registerJavaTimeTypeAdapters
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppNetworkManager {
    private val networkExceptionFactory = NetworkExceptionFactory()
    private val httpClient by lazy {
        setupHttpClient()
    }

    private fun setupHttpClient(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpBuilder.addInterceptor(httpLoggingInterceptor)
            .addInterceptor(
                OAuth2Interceptor(
                    SecurityRepositoryFactory.getOAuth2Repository(
                        BaseApplication.appContext,
                        com.github.kacso.androidcommons.BuildConfig.AUTH_ENDPOINT,
                        com.github.kacso.androidcommons.BuildConfig.AUTHORIZATION_KEY
                    )
                )
            ).addInterceptor(NetworkExceptionInterceptor(networkExceptionFactory))

        httpBuilder.connectTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(10L, TimeUnit.SECONDS)

        return httpBuilder.build()
    }

    private val restBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(com.github.kacso.androidcommons.BuildConfig.APP_ENDPOINT)
            .addCallAdapterFactory(LiveDataCallAdapterFactory(networkExceptionFactory))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(
                GsonConverterFactory.create(gson)
            )
    }

    private val gson = GsonBuilder()
        .registerJavaTimeTypeAdapters()
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