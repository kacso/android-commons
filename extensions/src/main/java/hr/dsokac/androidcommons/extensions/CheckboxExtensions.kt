package hr.dsokac.androidcommons.extensions

import android.widget.CheckBox
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 *
 * Extension class for Checkbox class
 *
 * @author Danijel Sokač
 */


/**
 * Displays real time checkbox value according to LiveData parameter
 *
 * @param owner     The LifecycleOwner which controls the observer
 * @param value     Boolean LiveData which updates current value of checkbox
 */
fun CheckBox.setLiveChecked(owner: LifecycleOwner, value: LiveData<Boolean>) {
    value.observe(owner, Observer {
        this.isChecked = it ?: false
    })
}