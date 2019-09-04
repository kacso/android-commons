package com.github.kacso.androidcommons.ui.fragments

import com.github.kacso.androidcommons.core.fragments.PageFragment
import com.github.kacso.androidcommons.core.fragments.PagerFragment
import com.github.kacso.androidcommons.core.mvvm.viewmodels.IBaseViewModel

class ViewPagerFragment : PagerFragment() {
    companion object {
        fun newInstance(): ViewPagerFragment {
            return ViewPagerFragment()
        }
    }

    private val pageFragments by lazy {
        listOf<PageFragment>(
            EntryListFragment.newInstance(),
            EntryPagedListFragment.newInstance()
        )
    }

    override val viewModel: IBaseViewModel? = null

    override fun getFragments(): List<PageFragment> = pageFragments
}