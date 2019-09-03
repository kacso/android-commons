package com.github.kacso.androidcommons.core.dialogs

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import java.util.concurrent.atomic.AtomicBoolean


/**
 * Class which implements common functionalities needed for progress dialogs
 * and makes abstraction for other components when accessing real implementation.
 *
 * @author Danijel Sokač
 */
abstract class AbstractProgressDialog : DialogFragment() {
    private var isShown = AtomicBoolean(false)

    fun isShown(): Boolean = isShown.get()

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager, tag)
        isShown.set(true)
    }

    override fun dismiss() {
        super.dismiss()
        isShown.set(false)
    }

    override fun dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss()
        isShown.set(false)
    }
}