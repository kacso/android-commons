package com.github.kacso.androidcommons.ui.fragments

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.fragments.PageListFragment
import com.github.kacso.androidcommons.models.ui.Entry
import com.github.kacso.androidcommons.ui.adapters.EntryListAdapter
import com.github.kacso.androidcommons.viewmodel.EntryListViewModel

class EntryListFragment : PageListFragment<Entry>() {
    companion object {
        fun newInstance(): EntryListFragment {
            return EntryListFragment()
        }
    }

    private val adapter by lazy {
        EntryListAdapter(viewModel.getData(), viewLifecycleOwner)
    }

    override val viewModel: EntryListViewModel by viewModels()

    override fun getAdapter(): RecyclerView.Adapter<*> = adapter

    override fun getTitleRes(): Int = R.string.title_entry_list_fragment

}