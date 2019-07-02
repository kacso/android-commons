package hr.dsokac.androidcommons.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import hr.dsokac.androidcommons.extensions.fragments.IExtendedFragment

/**
 *
 * Extension class for Fragment based classes
 *
 * @author Danijel Sokač
 */

typealias FragmentTransactionDecorator = (FragmentTransaction) -> Unit

/**
 * Add additional action to [FragmentTransaction] before committing
 *
 * @param decorator Instance of [FragmentTransactionDecorator] that will perform decoration. If set to null, no
 *                  action will be performed
 *
 * @return Returns same [FragmentTransaction] instance
 */
fun FragmentTransaction.decorate(decorator: FragmentTransactionDecorator?): FragmentTransaction {
    decorator?.invoke(this)
    return this
}

/**
 * Goes recursively through all displayed fragments and pops last displayed child
 *
 * @return true if back action was performed, otherwise false
 */
fun FragmentManager.goBack(): Boolean {
    val fragList = fragments
    for (frag in fragList) {
        if (frag.isVisible) {
            if (frag.childFragmentManager.goBack()) {
                if (frag is IExtendedFragment) {
                    frag.onChildFragmentBack()
                }
                return true
            }
        }
    }
    if (backStackEntryCount > 0) {
        popBackStackImmediate()
        return true
    }
    return false
}


/**
 * Replaces fragment [fragment] on place of [fragmentHolder].
 * Also, fragment is added to backstack in order to support back function on fragments.
 *
 * @param fragmentHolder    ID of view in which fragment will be displayed
 * @param fragment          Fragment instance to be displayed
 * @param tag               Tag of fragment, used for adding to backstack
 * @param decorator         Additional actions that should be applied to this transaction (e.g. animations)
 */
fun Fragment.showFragment(
    @IdRes fragmentHolder: Int, fragment: Fragment,
    tag: String,
    decorator: FragmentTransactionDecorator? = null
) {
    childFragmentManager
        .beginTransaction()
        .replace(fragmentHolder, fragment)
        .addToBackStack(tag)
        .decorate(decorator)
        .commit()
}

/**
 * Adds fragment [fragment] to [fragmentHolder] without adding it to the backstack.
 * Use it for adding fragment to the empty view
 *
 * @param fragmentHolder    ID of view in which fragment will be displayed
 * @param fragment          Fragment instance to be displayed
 * @param decorator         Additional actions that should be applied to this transaction (e.g. animations)
 */
fun Fragment.addFragment(
    @IdRes fragmentHolder: Int,
    fragment: Fragment,
    decorator: FragmentTransactionDecorator? = null
) {
    childFragmentManager
        .beginTransaction()
        .replace(fragmentHolder, fragment)
        .decorate(decorator)
        .commit()
}

/**
 * Adds fragment [fragment] to [fragmentHolder].
 *
 * In case that other fragment is already shown in fragmentHolder, that fragment will be hidden.
 * Also, if this fragment was previously added to this fragmentHolder, it will be re-shown.
 * Fragment will not be added to backstack.
 *
 * This function is useful when using bottom navigation view.
 *
 * @param fragmentHolder    ID of view in which fragment will be displayed
 * @param fragment          Fragment instance to be displayed
 * @param tag               Tag of fragment, used for re-attaching fragment
 * @param decorator         Additional actions that should be applied to this transaction (e.g. animations)
 */
fun Fragment.attachFragment(
    @IdRes fragmentHolder: Int,
    fragment: Fragment,
    tag: String,
    decorator: FragmentTransactionDecorator? = null
) {
    val transaction = childFragmentManager.beginTransaction()
    val existingFragment = childFragmentManager.findFragmentByTag(tag)

    val fragments = childFragmentManager.fragments
    for (f in fragments) {
        if (f != null && f.isVisible && f.id == fragmentHolder) {
            transaction.hide(f)
            break
        }
    }


    if (existingFragment != null) {
        transaction
            .show(existingFragment)
    } else {
        transaction
            .add(fragmentHolder, fragment, tag)
    }
    transaction.decorate(decorator)
        .commit()
}