package com.github.kacso.androidcommons.extensions.fragmenttransaction.decorators

import androidx.fragment.app.FragmentTransaction
import com.github.kacso.androidcommons.extensions.FragmentTransactionDecorator
import com.github.kacso.androidcommons.extensions.R

object FadeAnimation : FragmentTransactionDecorator {
    override fun invoke(ft: FragmentTransaction) {
        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
    }
}