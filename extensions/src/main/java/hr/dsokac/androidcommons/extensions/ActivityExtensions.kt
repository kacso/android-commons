package hr.dsokac.androidcommons.extensions

import android.util.TypedValue
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

/**
 *
 * Extension class for Activity based classes
 *
 * @author Danijel Sokač
 */

/**
 * Replaces fragment [fragment] on place of [fragmentHolder].
 * Also, fragment is added to backstack in order to support back function on fragments.
 *
 * @param fragmentHolder    ID of view in which fragment will be displayed
 * @param fragment          Fragment instance to be displayed
 * @param tag               Tag of fragment, used for adding to backstack
 * @param decorator         Additional actions that should be applied to this transaction (e.g. animations)
 */
fun FragmentActivity.showFragment(
    @IdRes fragmentHolder: Int, fragment: Fragment,
    tag: String,
    decorator: FragmentTransactionDecorator? = null
) {
    supportFragmentManager
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
fun FragmentActivity.addFragment(
    @IdRes fragmentHolder: Int,
    fragment: Fragment,
    decorator: FragmentTransactionDecorator? = null
) {
    supportFragmentManager
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
fun FragmentActivity.attachFragment(
    @IdRes fragmentHolder: Int,
    fragment: Fragment,
    tag: String,
    decorator: FragmentTransactionDecorator? = null
) {
    val transaction = supportFragmentManager.beginTransaction()
    val existingFragment = supportFragmentManager.findFragmentByTag(tag)

    val fragments = supportFragmentManager.fragments
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

/**
 * Clears all fragments from backstack
 */
fun FragmentActivity.clearFragmentHistory() {
    supportFragmentManager
        .popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

/**
 * Performs back action on activity.
 * In case that there is fragments on the backstack, fragment on top of the stack will be
 * displayed to the user. Otherwise, activity will be finished
 */
fun FragmentActivity.goBack() {
    supportFragmentManager.goBack()

    if (supportFragmentManager.backStackEntryCount <= 0) {
        finish()
    }
}

/**
 * Calculates height of action bar
 *
 * @return action bar height in pixels
 */
fun FragmentActivity.actionBarHeight(): Int {
    val tv = TypedValue()
    if (theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
        return TypedValue.complexToDimensionPixelSize(tv.data, resources.displayMetrics)
    }
    return 0
}
