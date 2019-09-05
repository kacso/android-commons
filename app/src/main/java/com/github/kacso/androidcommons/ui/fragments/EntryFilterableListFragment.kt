package com.github.kacso.androidcommons.ui.fragments

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.github.kacso.androidcommons.core.fragments.FilterableListFragment
import com.github.kacso.androidcommons.models.ui.Entry
import com.github.kacso.androidcommons.ui.adapters.EntryListAdapter
import com.github.kacso.androidcommons.viewmodel.EntryFilterableListViewModel

class EntryFilterableListFragment : FilterableListFragment<Entry>() {
    companion object {
        fun newInstance(): EntryFilterableListFragment {
            return EntryFilterableListFragment()
        }
    }

    override val viewModel: EntryFilterableListViewModel by viewModels()

    private val adapter by lazy {
        EntryListAdapter(viewModel.getData(), viewLifecycleOwner)
    }

    override fun getAdapter(): RecyclerView.Adapter<*> = adapter
}