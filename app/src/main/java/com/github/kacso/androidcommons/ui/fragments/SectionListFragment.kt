package com.github.kacso.androidcommons.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.adapters.models.SectionItem
import com.github.kacso.androidcommons.core.adapters.utils.HeaderItemDecoration
import com.github.kacso.androidcommons.core.fragments.PageListFragment
import com.github.kacso.androidcommons.ui.adapters.SectionListAdapter
import com.github.kacso.androidcommons.viewmodel.SectionListViewModel

class SectionListFragment : PageListFragment<SectionItem<*, *>>() {
    companion object {
        fun newInstance(): SectionListFragment {
            return SectionListFragment()
        }
    }

    private val adapter: SectionListAdapter by lazy {
        SectionListAdapter(viewModel.getData(), viewLifecycleOwner)
    }

    override val viewModel: SectionListViewModel by viewModels()

    override fun getAdapter(): RecyclerView.Adapter<*> = adapter

    override fun getTitleRes(): Int = R.string.title_section_list_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getListView().apply {
            addItemDecoration(
                HeaderItemDecoration(
                    this,
                    adapter as HeaderItemDecoration.StickyHeaderInterface
                )
            )
        }
    }

}