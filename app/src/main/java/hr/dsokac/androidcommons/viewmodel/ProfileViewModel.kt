package hr.dsokac.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hr.dsokac.androidcommons.BuildConfig
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.core.BaseApplication
import hr.dsokac.androidcommons.core.mvvm.viewmodels.BaseViewModel
import hr.dsokac.androidcommons.data.ErrorHolder
import hr.dsokac.androidcommons.data.Resource
import hr.dsokac.androidcommons.db.AppDatabase
import hr.dsokac.androidcommons.logger.log
import hr.dsokac.androidcommons.models.ui.User
import hr.dsokac.androidcommons.network.exceptions.RequestFailedException
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.network.factories.NetworkExceptionFactory
import hr.dsokac.androidcommons.network.interceptors.NetworkExceptionInterceptor
import hr.dsokac.androidcommons.network.managers.AppNetworkManager
import hr.dsokac.androidcommons.repositories.UserResource
import hr.dsokac.androidcommons.security.factories.SecurityRepositoryFactory
import kotlinx.coroutines.launch

class ProfileViewModel : BaseViewModel() {
    private val authRepository by lazy {
        SecurityRepositoryFactory.getOAuth2Repository(
            context = BaseApplication.appContext,
            baseUrl = BuildConfig.AUTH_ENDPOINT,
            authorizationKey = BuildConfig.AUTHORIZATION_KEY,
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