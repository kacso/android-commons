package com.github.kacso.androidcommons.extensions.fragmenttransaction.decorators

import androidx.fragment.app.FragmentTransaction
import com.github.kacso.androidcommons.extensions.FragmentTransactionDecorator
import com.github.kacso.androidcommons.extensions.R

object SlideUpToDownAnimation : FragmentTransactionDecorator {
    override fun invoke(ft: FragmentTransaction) {
        ft.setCustomAnimations(R.anim.entrance_up, R.anim.delay_anim, R.anim.delay_anim, R.anim.exit_up)
    }
}