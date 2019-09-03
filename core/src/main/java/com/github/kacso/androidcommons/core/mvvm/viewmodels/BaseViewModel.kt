package com.github.kacso.androidcommons.core.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kacso.androidcommons.data.ErrorHolder
import com.github.kacso.androidcommons.data.MessageHolder

abstract class BaseViewModel : ViewModel(), IBaseViewModel {
    protected val error: MutableLiveData<ErrorHolder> = MutableLiveData()
    protected val message: MutableLiveData<MessageHolder> = MutableLiveData()
    protected val isProgressActive: MutableLiveData<Boolean> = MutableLiveData()

    override fun getError(): LiveData<ErrorHolder> = error
    override fun getMessage(): LiveData<MessageHolder> = message
    override fun getIsProgressActive(): LiveData<Boolean> = isProgressActive
}