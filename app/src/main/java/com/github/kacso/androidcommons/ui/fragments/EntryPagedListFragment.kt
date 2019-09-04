package com.github.kacso.androidcommons.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.fragments.PageListFragment
import com.github.kacso.androidcommons.models.ui.Entry
import com.github.kacso.androidcommons.ui.adapters.EntryPageListAdapter
import com.github.kacso.androidcommons.viewmodel.EntryPagedListViewModel

class EntryPagedListFragment : PageListFragment<Entry>() {
    companion object {
        fun newInstance(): EntryPagedListFragment {
            return EntryPagedListFragment()
        }
    }

    private val adapter by lazy {
        EntryPageListAdapter(viewModel.getData() as LiveData<PagedList<Entry>>, viewLifecycleOwner)
    }

    override val viewModel: EntryPagedListViewModel by viewModels()

    override fun getAdapter(): RecyclerView.Adapter<*> = adapter

    override fun getTitleRes(): Int = R.string.title_entry_paged_list_fragment

}