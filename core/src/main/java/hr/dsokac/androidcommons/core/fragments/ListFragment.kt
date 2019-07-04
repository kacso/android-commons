package hr.dsokac.androidcommons.core.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import hr.dsokac.androidcommons.core.R
import hr.dsokac.androidcommons.core.mvvm.viewmodels.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 *
 * This class provides default implementation for fragments with [RecyclerView]
 *
 * @author Danijel Sokač
 */
abstract class ListFragment<T> : BaseFragment() {
    abstract override val viewModel: ListViewModel<T>

    /**
     * Returns RecyclerView which will display data.
     * Override this function in case when you are using custom layout
     */
    open fun getListView(): RecyclerView {
        return rootView.recyclerView
    }

    /**
     * Returns SwipeRefreshLayout which will refresh data.
     * Override this function in case when you are using custom layout.
     *
     * @return your SwipeRefreshLayout or null in case you don't wan't to use this feature
     */
    open fun getSwipeRefreshView(): SwipeRefreshLayout? {
        return rootView.swipeRefresh
    }

    /**
     * Function for retrieving adapter for RecyclerView.
     * Make sure to return always same instance of adapter!
     *
     * @return adapter for RecyclerView
     */
    abstract fun getAdapter(): RecyclerView.Adapter<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()

        getSwipeRefreshView()?.setOnRefreshListener {
            viewModel.refreshData()
        }
    }

    override fun getLayout(): Int = R.layout.fragment_list

    /**
     * If [SwipeRefreshLayout] is defined, use his progress indicator, otherwise call super
     */
    override fun hideProgress() {
        val refreshView = getSwipeRefreshView()

        if (refreshView != null) {
            refreshView.isRefreshing = false
        } else {
            super.hideProgress()
        }
    }

    /**
     * If [SwipeRefreshLayout] is defined, use his progress indicator, otherwise call super
     */
    override fun showProgress() {
        val refreshView = getSwipeRefreshView()

        if (refreshView != null) {
            refreshView.isRefreshing = true
        } else {
            super.showProgress()
        }
    }

    private fun setupList() {
        val linearLayoutManager = LinearLayoutManager(activity)
        getListView().adapter = getAdapter()
        getListView().layoutManager = linearLayoutManager

        getAdapter().registerAdapterDataObserver(adapterDataObserver)
    }

    /**
     * Return view that will be displayed to user when there is no data in [RecyclerView].
     * By default it will return [TextView] with default message. To change message displayed
     * call [setEmptyListViewText].
     *
     * Override this method if you would like to display more complex view to the user.
     *
     * @return [View] that will be displayed if there is no data in [RecyclerView], if null
     *          nothing will be displayed in such situation
     */
    open fun getEmptyListView(): View? = rootView.emptyListView

    /**
     * Set [msg] as text that should be displayed to user when there is no data in [RecyclerView].
     * This function will work with any [View] returned from [getEmptyListView] which extends [TextView].
     *
     * If you are using custom [View], make sure that it extends [TextView] or override this
     * function and give your implementation of setting text message.
     *
     * @param msg text to be displayed to user inside [View] returned by [getEmptyListView]
     */
    open fun setEmptyListViewText(msg: String) {
        val emptyListView = getEmptyListView()
        if (emptyListView is TextView) {
            emptyListView.text = msg
        }
    }

    /**
     * Observer which will display empty list view returned by [getEmptyListView] to the user
     * when there is no data in [RecyclerView].
     *
     * You can override this observer if default implementation does not meet your requirements.
     */
    open val adapterDataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
            refreshView()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            refreshView()
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount)
            refreshView()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            refreshView()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            super.onItemRangeChanged(positionStart, itemCount)
            refreshView()
        }

        fun refreshView() {
            val emptyViewVisible = getAdapter().itemCount == 0
            getEmptyListView()?.visibility = if (emptyViewVisible) View.VISIBLE else View.GONE
            getListView().visibility = if (emptyViewVisible) View.GONE else View.VISIBLE
        }
    }
}