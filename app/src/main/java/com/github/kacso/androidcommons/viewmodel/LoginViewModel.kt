package com.github.kacso.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.BaseApplication
import com.github.kacso.androidcommons.core.mvvm.viewmodels.BaseViewModel
import com.github.kacso.androidcommons.data.ErrorHolder
import com.github.kacso.androidcommons.data.Resource
import com.github.kacso.androidcommons.db.AppDatabase
import com.github.kacso.androidcommons.logger.log
import com.github.kacso.androidcommons.network.exceptions.BadRequest
import com.github.kacso.androidcommons.network.exceptions.RequestFailedException
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory
import com.github.kacso.androidcommons.network.interceptors.NetworkExceptionInterceptor
import com.github.kacso.androidcommons.security.factories.SecurityRepositoryFactory
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {
    private val authRepository by lazy {
        SecurityRepositoryFactory.getOAuth2Repository(
            context = BaseApplication.appContext,
            baseUrl = com.github.kacso.androidcommons.BuildConfig.AUTH_ENDPOINT,
            authorizationKey = com.github.kacso.androidcommons.BuildConfig.AUTHORIZATION_KEY,
            networkExceptionInterceptor = NetworkExceptionInterceptor(NetworkExceptionFactory())
        )
    }

    fun login(username: String, password: String): LiveData<Resource<Any>> {
        val ld = MutableLiveData<Resource<Any>>()

        viewModelScope.launch {
            log(tag = "LoginViewModel", message = "Initiating login for $username")
            ld.postValue(Resource.Loading())

            runCatching {
                authRepository.login(username, password)
            }.onSuccess {
                log(tag = "LoginViewModel", message = "$username has been logged in successfully.")
                AppDatabase.resetInstance(username)
                ld.postValue(Resource.Success(Any()))
            }.onFailure {
                it.log()
                val error = when {
                    it is RequestFailedException -> ErrorHolder(R.string.error_no_internet, it.localizedMessage, it)
                    it is Unauthorized -> ErrorHolder(R.string.error_wrong_credentials, it.localizedMessage, it)
                    it is BadRequest && it.message?.contains("invalid_grant") == true -> ErrorHolder(
                        R.string.error_wrong_credentials,
                        it.localizedMessage,
                        it
                    )
                    else -> ErrorHolder(R.string.error_unexpected, it.localizedMessage, it)
                }
                ld.postValue(Resource.Error(error))
            }
        }
        return ld
    }
}