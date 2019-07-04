package hr.dsokac.androidcommons.core.mvvm.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hr.dsokac.androidcommons.core.models.ErrorHolder
import hr.dsokac.androidcommons.core.models.MessageHolder

abstract class AndroidBaseViewModel(application: Application) : AndroidViewModel(application), IBaseViewModel {
    protected val error: MutableLiveData<ErrorHolder> = MutableLiveData()
    protected val message: MutableLiveData<MessageHolder> = MutableLiveData()
    protected val isProgressActive: MutableLiveData<Boolean> = MutableLiveData()


    override fun getError(): LiveData<ErrorHolder> = error
    override fun getMessage(): LiveData<MessageHolder> = message
    override fun getIsProgressActive(): LiveData<Boolean> = isProgressActive
}