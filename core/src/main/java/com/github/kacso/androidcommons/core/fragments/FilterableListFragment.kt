package com.github.kacso.androidcommons.core.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.github.kacso.androidcommons.core.R
import com.github.kacso.androidcommons.core.mvvm.viewmodels.FilterableListViewModel
import kotlinx.android.synthetic.main.fragment_filterable_list.view.*

/**
 *
 * This class provides default implementation for fragments with [RecyclerView] and search field
 *
 * @author Danijel Sokač
 */
abstract class FilterableListFragment<T> : ListFragment<T>() {
    abstract override val viewModel: FilterableListViewModel<T, String>

    override fun getListView(): RecyclerView {
        return rootView.recyclerView
    }

    override fun getSwipeRefreshView(): SwipeRefreshLayout? {
        return rootView.swipeRefresh
    }

    override val layoutRes: Int = R.layout.fragment_filterable_list

    override fun hideProgress() {
        val refreshView = getSwipeRefreshView()

        if (refreshView != null) {
            refreshView.isRefreshing = false
        } else {
            super.hideProgress()
        }
    }

    override fun showProgress() {
        val refreshView = getSwipeRefreshView()

        if (refreshView != null) {
            refreshView.isRefreshing = true
        } else {
            super.showProgress()
        }
    }

    override fun getEmptyListView(): View? = rootView.emptyListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSearchListener()
    }

    /**
     * Initialize [SearchView] listener in order to update search term in view model.
     *
     * By default, whenever query text changes, view model search term is updated
     */
    protected open fun setSearchListener() {
        rootView.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = true

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterTerm = newText
                return true
            }
        })
    }
}