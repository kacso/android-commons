package hr.dsokac.androidcommons.ui.fragments

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.core.fragments.PageListFragment
import hr.dsokac.androidcommons.models.ui.Entry
import hr.dsokac.androidcommons.ui.adapters.EntryListAdapter
import hr.dsokac.androidcommons.viewmodel.EntryListViewModel

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