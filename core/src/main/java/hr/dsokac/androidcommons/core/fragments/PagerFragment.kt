package hr.dsokac.androidcommons.core.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import hr.dsokac.androidcommons.core.R
import hr.dsokac.androidcommons.core.views.PagerView
import kotlinx.android.synthetic.main.base_fragment_pager.view.*

/**
 * Abstract class with common functionalities which are used in fragment with [ViewPager]
 *
 * @author Danijel Sokač
 */
abstract class PagerFragment : BaseFragment(), PagerView {

    override val layoutRes: Int = R.layout.base_fragment_pager

    /**
     * Returns ViewPager which will display data.
     */
    protected open fun getPagerView(): ViewPager = rootView.viewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        getPagerView().adapter =
            object : FragmentStatePagerAdapter(
                childFragmentManager,
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
            ) {
                override fun getItem(position: Int): Fragment {
                    return getFragments()[position]
                }

                override fun getCount(): Int = getFragments().size

                override fun getPageTitle(position: Int): CharSequence? {
                    return getString(getFragments()[position].getTitleRes())
                }
            }
    }
}