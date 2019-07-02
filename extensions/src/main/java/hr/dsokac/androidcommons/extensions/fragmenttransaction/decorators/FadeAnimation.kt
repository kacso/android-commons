package hr.dsokac.androidcommons.extensions.fragmenttransaction.decorators

import androidx.fragment.app.FragmentTransaction
import hr.dsokac.androidcommons.extensions.FragmentTransactionDecorator
import hr.dsokac.androidcommons.extensions.R

object FadeAnimation : FragmentTransactionDecorator {
    override fun invoke(ft: FragmentTransaction) {
        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
    }
}