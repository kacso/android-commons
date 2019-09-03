package com.github.kacso.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.github.kacso.androidcommons.core.BaseApplication
import com.github.kacso.androidcommons.core.livedata.SingleLiveEvent
import com.github.kacso.androidcommons.core.mvvm.viewmodels.BaseViewModel
import com.github.kacso.androidcommons.data.ErrorHolder
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory
import com.github.kacso.androidcommons.network.interceptors.NetworkExceptionInterceptor
import com.github.kacso.androidcommons.security.factories.SecurityRepositoryFactory
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashViewModel : BaseViewModel() {
    private val authRepository by lazy {
        SecurityRepositoryFactory.getOAuth2Repository(
            context = BaseApplication.appContext,
            baseUrl = com.github.kacso.androidcommons.BuildConfig.AUTH_ENDPOINT,
            authorizationKey = com.github.kacso.androidcommons.BuildConfig.AUTHORIZATION_KEY,
            networkExceptionInterceptor = NetworkExceptionInterceptor(NetworkExceptionFactory())
        )
    }

    fun persistLogin(): LiveData<Void> {
        val ld = SingleLiveEvent<Void>()

        viewModelScope.launch {
            //Sleep for few seconds in order to make splash visible to user
            sleep(2000)
            val token = authRepository.getAccessToken()

            if (token.isNullOrEmpty()) {
                val errorHolder = ErrorHolder(null, "Empty token", Unauthorized())
                error.postValue(errorHolder)
            } else {
                ld.call()
            }
        }
        return ld
    }
}