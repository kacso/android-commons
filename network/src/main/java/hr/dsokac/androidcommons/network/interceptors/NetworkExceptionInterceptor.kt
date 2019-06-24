package hr.dsokac.androidcommons.network.interceptors

import hr.dsokac.androidcommons.network.exceptions.UnexpectedError
import hr.dsokac.androidcommons.network.factories.INetworkExceptionFactory
import okhttp3.Interceptor
import okhttp3.Response

class NetworkExceptionInterceptor(
    private val networkExceptionFactory: INetworkExceptionFactory
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        runCatching {
            chain.proceed(chain.request())
        }.onSuccess {
            if (it.isSuccessful) return it
            throw networkExceptionFactory.fromHttpResponse(retrofit2.Response.error<Any>(it.body()!!, it))
        }.onFailure {
            throw networkExceptionFactory.toNetworkException(it)
        }
        throw UnexpectedError()
    }
}