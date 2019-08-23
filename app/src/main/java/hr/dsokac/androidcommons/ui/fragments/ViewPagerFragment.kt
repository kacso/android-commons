package hr.dsokac.androidcommons.ui.fragments

import hr.dsokac.androidcommons.core.fragments.PageFragment
import hr.dsokac.androidcommons.core.fragments.PagerFragment
import hr.dsokac.androidcommons.core.mvvm.viewmodels.IBaseViewModel

class ViewPagerFragment : PagerFragment() {
    companion object {
        fun newInstance(): ViewPagerFragment {
            return ViewPagerFragment()
        }
    }

    private val pageFragments by lazy {
        listOf<PageFragment>(
            EntryListFragment.newInstance()
        )
    }

    override val viewModel: IBaseViewModel? = null

    override fun getFragments(): List<PageFragment> = pageFragments
}