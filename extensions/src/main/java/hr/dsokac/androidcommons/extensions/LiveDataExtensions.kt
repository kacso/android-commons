package hr.dsokac.androidcommons.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 *
 * Extension class for LiveData based classes
 *
 * @author Danijel Sokač
 */


/**
 * Create [LiveData] from any value
 *
 * @return [LiveData] with value set to [this]
 */
fun <T> T.toLiveData(): LiveData<T> {
    val ld = MutableLiveData<T>()
    ld.postValue(this)
    return ld
}