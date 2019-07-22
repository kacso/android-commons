package hr.dsokac.androidcommons.core.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import hr.dsokac.androidcommons.core.livedata.ObserverAwareLiveData.ActiveStatusObserver

/**
 * [LiveData] which exposes [onActive] and [onInactive] publicly through [ActiveStatusObserver]
 * This implementation is useful when you need to clear background sources once there is no observers.
 *
 * @param <T> The type of data hold by this instance
 */
class ObserverAwareLiveData<T> : MutableLiveData<T>() {
    private val activeStatusObservers = HashSet<ActiveStatusObserver>()
    override fun onInactive() {
        super.onInactive()

        activeStatusObservers.forEach { it.onInactive() }
    }

    override fun onActive() {
        super.onActive()

        activeStatusObservers.forEach { it.onActive() }
    }

    /**
     * Adds the given [observer] to the observers list
     */
    fun addActiveStatusObserver(observer: ActiveStatusObserver) {
        activeStatusObservers.add(observer)
    }

    /**
     * Removes given [observer] from the observers list
     */
    fun removeActiveStatusObserver(observer: ActiveStatusObserver) {
        activeStatusObservers.remove(observer)
    }

    /**
     * Observer which propagates [LiveData] observer active status
     */
    interface ActiveStatusObserver {

        /**
         * Called when the number of active observers change to 1 from 0.
         * <p>
         * This callback can be used to know that this LiveData is being used thus should be kept
         * up to date.
         */
        fun onActive()

        /**
         * Called when the number of active observers change from 1 to 0.
         * <p>
         * This does not mean that there are no observers left, there may still be observers but their
         * lifecycle states aren't {@link Lifecycle.State#STARTED} or {@link Lifecycle.State#RESUMED}
         * (like an Activity in the back stack).
         * <p>
         * You can check if there are observers via {@link #hasObservers()}.
         */
        fun onInactive()
    }
}