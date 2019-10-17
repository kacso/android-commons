package com.github.kacso.androidcommons.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
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

/**
 * Same as [combineWith] with difference that it can emit null items. This means that result source
 * will not wait for both sources to emit values.
 */
fun <T, K, R> LiveData<T?>.nullableCombineWith(
    liveData: LiveData<K?>,
    block: (T?, K?) -> R?
): LiveData<R?> {
    val result = MediatorLiveData<R?>()
    result.addSource(this) {
        result.value = block.invoke(this.value, liveData.value)
    }
    result.addSource(liveData) {
        result.value = block.invoke(this.value, liveData.value)
    }
    return result
}

/**
 * Combines two [LiveData] sources into one using [block] function as merger.
 * Returned source will only emit when data is ready (not null) from both sources.
 *
 * @param T Data type of [this]
 * @param K Data type of [liveData]
 * @param R Data type returned by [block]
 * @param liveData [LiveData] source to be merged with [this]
 * @param block merger function
 *
 * @return [LiveData] which holds merged sources
 */
fun <T, K, R> LiveData<T>.combineWith(
    liveData: LiveData<K>,
    block: (T, K) -> R
): LiveData<R> {

    val result = MediatorLiveData<R>()
    result.addSource(this) {
        val tValue = this.value ?: return@addSource
        val kValue = liveData.value ?: return@addSource
        result.value = block.invoke(tValue, kValue)
    }
    result.addSource(liveData) {
        val tValue = this.value ?: return@addSource
        val kValue = liveData.value ?: return@addSource
        result.value = block.invoke(tValue, kValue)
    }
    return result
}