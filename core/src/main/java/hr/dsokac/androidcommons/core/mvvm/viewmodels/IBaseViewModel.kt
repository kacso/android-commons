package hr.dsokac.androidcommons.core.mvvm.viewmodels

import androidx.lifecycle.LiveData
import hr.dsokac.androidcommons.data.ErrorHolder
import hr.dsokac.androidcommons.data.MessageHolder

interface IBaseViewModel {
    fun getError(): LiveData<ErrorHolder>
    fun getMessage(): LiveData<MessageHolder>
    fun getIsProgressActive(): LiveData<Boolean>
}