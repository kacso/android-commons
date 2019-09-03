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
import com.github.kacso.androidcommons.models.ui.User
import com.github.kacso.androidcommons.network.exceptions.RequestFailedException
import com.github.kacso.androidcommons.network.exceptions.Unauthorized
import com.github.kacso.androidcommons.network.factories.NetworkExceptionFactory
import com.github.kacso.androidcommons.network.interceptors.NetworkExceptionInterceptor
import com.github.kacso.androidcommons.network.managers.AppNetworkManager
import com.github.kacso.androidcommons.repositories.UserResource
import com.github.kacso.androidcommons.security.factories.SecurityRepositoryFactory
import kotlinx.coroutines.launch

class ProfileViewModel : BaseViewModel() {
    private val authRepository by lazy {
        SecurityRepositoryFactory.getOAuth2Repository(
            context = BaseApplication.appContext,
            baseUrl = com.github.kacso.androidcommons.BuildConfig.AUTH_ENDPOINT,
            authorizationKey = com.github.kacso.androidcommons.BuildConfig.AUTHORIZATION_KEY,
            networkExceptionInterceptor = NetworkExceptionInterceptor(NetworkExceptionFactory())
        )
    }

    private val userResource = UserResource(
        userDao = AppDatabase.getInstance().getUserDao(),
        service = AppNetworkManager.getService()
    )

    fun logout(): LiveData<Resource<Any>> {
        val ld = MutableLiveData<Resource<Any>>()

        viewModelScope.launch {
            log(tag = "ProfileViewModel", message = "Initiating logout")
            ld.postValue(Resource.Loading())

            runCatching {
                authRepository.logout()
            }.onSuccess {
                log(tag = "ProfileViewModel", message = "Logout was successful.")
                ld.postValue(Resource.Success(Any()))
            }.onFailure {
                it.log()
                when (it) {
                    is RequestFailedException -> ld.postValue(
                        Resource.Error(
                            ErrorHolder(
                                R.string.error_no_internet,
                                it.localizedMessage,
                                it
                            )
                        )
                    )
                    is Unauthorized -> ld.postValue(Resource.Success(Any()))
                    else -> ld.postValue(
                        Resource.Error(
                            ErrorHolder(
                                R.string.error_unexpected,
                                it.localizedMessage,
                                it
                            )
                        )
                    )
                }
            }
        }
        return ld
    }

    fun getUser(): LiveData<Resource<User>> {
        return userResource.asLiveData()
    }
}