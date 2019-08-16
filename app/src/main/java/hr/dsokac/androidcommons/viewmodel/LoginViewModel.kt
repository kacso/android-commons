package hr.dsokac.androidcommons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.core.BaseApplication
import hr.dsokac.androidcommons.core.mvvm.viewmodels.BaseViewModel
import hr.dsokac.androidcommons.data.ErrorHolder
import hr.dsokac.androidcommons.data.Resource
import hr.dsokac.androidcommons.network.exceptions.BadRequest
import hr.dsokac.androidcommons.network.exceptions.RequestFailedException
import hr.dsokac.androidcommons.network.exceptions.Unauthorized
import hr.dsokac.androidcommons.network.factories.NetworkExceptionFactory
import hr.dsokac.androidcommons.network.interceptors.NetworkExceptionInterceptor
import hr.dsokac.androidcommons.security.factories.SecurityRepositoryFactory
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {
    //TODO Inject repository
    private val authRepository by lazy {
        SecurityRepositoryFactory.getOAuth2Repository(
            context = BaseApplication.appContext,
            baseUrl = "http://192.168.0.106:8080/auth/",
            authorizationKey = "Basic VGVzdDoxMjM0",
            networkExceptionInterceptor = NetworkExceptionInterceptor(NetworkExceptionFactory())
        )
    }

    fun login(username: String, password: String): LiveData<Resource<Any>> {
        val ld = MutableLiveData<Resource<Any>>()

        viewModelScope.launch {
            ld.postValue(Resource.Loading())

            runCatching {
                authRepository.login(username, password)
            }.onSuccess {
                ld.postValue(Resource.Success(Any()))
            }.onFailure {
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