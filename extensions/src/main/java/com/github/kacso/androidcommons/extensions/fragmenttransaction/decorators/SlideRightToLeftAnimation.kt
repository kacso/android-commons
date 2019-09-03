package com.github.kacso.androidcommons.extensions.fragmenttransaction.decorators

import androidx.fragment.app.FragmentTransaction
import com.github.kacso.androidcommons.extensions.FragmentTransactionDecorator
import com.github.kacso.androidcommons.extensions.R

object SlideRightToLeftAnimation : FragmentTransactionDecorator {
    override fun invoke(ft: FragmentTransaction) {
        ft.setCustomAnimations(R.anim.entrance_left, R.anim.exit_right, R.anim.entrance_right, R.anim.exit_left)
    }
}