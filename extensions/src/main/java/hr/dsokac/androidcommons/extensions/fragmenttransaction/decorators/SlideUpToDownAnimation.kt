package hr.dsokac.androidcommons.extensions.fragmenttransaction.decorators

import androidx.fragment.app.FragmentTransaction
import hr.dsokac.androidcommons.extensions.FragmentTransactionDecorator
import hr.dsokac.androidcommons.extensions.R

object SlideUpToDownAnimation : FragmentTransactionDecorator {
    override fun invoke(ft: FragmentTransaction) {
        ft.setCustomAnimations(R.anim.entrance_up, R.anim.delay_anim, R.anim.delay_anim, R.anim.exit_up)
    }
}