package com.github.kacso.androidcommons.core.views

import androidx.viewpager.widget.ViewPager
import com.github.kacso.androidcommons.core.fragments.PageFragment

/**
 * Interface which defines basic functionalities of view with ViewPager
 *
 * @author Danijel Sokač
 */
interface PagerView {
    /**
     * Function to retrieve fragments for [ViewPager]
     *
     * @return list of fragments to be displayed in [ViewPager]
     */
    fun getFragments(): List<PageFragment>
}