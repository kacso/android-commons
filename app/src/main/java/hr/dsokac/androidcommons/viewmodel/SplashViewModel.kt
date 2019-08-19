package hr.dsokac.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.dsokac.androidcommons.BuildConfig
import hr.dsokac.androidcommons.core.BaseApplication
import hr.dsokac.androidcommons.core.livedata.SingleLiveEvent
import hr.dsokac.androidcommons.core.mvvm.viewmodels.BaseViewModel
import hr.dsokac.androidcommons.data.ErrorHolder
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.network.factories.NetworkExceptionFactory
import hr.dsokac.androidcommons.network.interceptors.NetworkExceptionInterceptor
import hr.dsokac.androidcommons.security.factories.SecurityRepositoryFactory
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class SplashViewModel : BaseViewModel() {
    private val authRepository by lazy {
        SecurityRepositoryFactory.getOAuth2Repository(
            context = BaseApplication.appContext,
            baseUrl = BuildConfig.AUTH_ENDPOINT,
            authorizationKey = BuildConfig.AUTHORIZATION_KEY,
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