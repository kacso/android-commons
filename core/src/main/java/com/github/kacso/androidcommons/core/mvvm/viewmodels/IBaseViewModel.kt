package com.github.kacso.androidcommons.core.mvvm.viewmodels

import androidx.lifecycle.LiveData
import com.github.kacso.androidcommons.data.ErrorHolder
import com.github.kacso.androidcommons.data.MessageHolder

interface IBaseViewModel {
    fun getError(): LiveData<ErrorHolder>
    fun getMessage(): LiveData<MessageHolder>
    fun getIsProgressActive(): LiveData<Boolean>
}