package hr.dsokac.androidcommons.core.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import hr.dsokac.androidcommons.core.adapters.utils.DefaultDiffUtilsItemCallback
import hr.dsokac.androidcommons.core.adapters.viewholders.BaseViewHolder

abstract class PagedLiveDataListAdapter<T : Any, VH : BaseViewHolder<T>>(
    private val items: LiveData<PagedList<T>>,
    private val lifecycleOwner: LifecycleOwner,
    diffUtilCallback: DiffUtil.ItemCallback<T> = DefaultDiffUtilsItemCallback()
) : PagedListAdapter<T, VH>(diffUtilCallback) {
    private lateinit var recyclerView: RecyclerView

    /**
     * Method called when new ViewHolder needs to be created
     *
     * @param view  inflated view
     *
     * @return new viewHolder
     */
    abstract fun createViewHolder(view: View): VH

    /**
     * Returns layout to be used for displaying list item
     */
    @get:LayoutRes
    abstract val itemLayoutRes: Int

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView

        items.observe(lifecycleOwner, Observer {
            submitList(it)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(itemLayoutRes, parent, false)

        return createViewHolder(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}