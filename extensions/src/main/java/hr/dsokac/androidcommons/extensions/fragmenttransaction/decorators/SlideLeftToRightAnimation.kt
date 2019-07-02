package hr.dsokac.androidcommons.extensions.fragmenttransaction.decorators

import androidx.fragment.app.FragmentTransaction
import hr.dsokac.androidcommons.extensions.FragmentTransactionDecorator
import hr.dsokac.androidcommons.extensions.R

object SlideLeftToRightAnimation : FragmentTransactionDecorator {
    override fun invoke(ft: FragmentTransaction) {
        ft.setCustomAnimations(R.anim.entrance_right, R.anim.exit_left, R.anim.entrance_left, R.anim.exit_right)
    }
}