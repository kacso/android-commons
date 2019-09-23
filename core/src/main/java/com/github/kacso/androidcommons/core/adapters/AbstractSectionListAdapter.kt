package com.github.kacso.androidcommons.core.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.kacso.androidcommons.core.adapters.models.SectionItem
import com.github.kacso.androidcommons.core.adapters.utils.DefaultDiffUtilsItemCallback
import com.github.kacso.androidcommons.core.adapters.utils.HeaderItemDecoration
import com.github.kacso.androidcommons.core.adapters.viewholders.AbstractSectionViewHolder

/**
 * Abstract implementation of [RecyclerView.Adapter] which works with [LiveData] list and
 * groups list items into sections. This adapter provides support for multiple header and subitem types.
 * This adapter will automatically update list when live data emit changes.
 *
 * @property items list of [SectionItem] to be shown, wrapped in [LiveData]
 * @property lifecycleOwner    lifecycle owner on which list modifications will be observed
 */
abstract class AbstractSectionListAdapter(
    private val items: LiveData<List<SectionItem<*, *>>>,
    private val lifecycleOwner: LifecycleOwner,
    diffUtilCallback: DiffUtil.ItemCallback<Any> = DefaultDiffUtilsItemCallback()
) : ListAdapter<Any, AbstractSectionViewHolder>(diffUtilCallback),
    HeaderItemDecoration.StickyHeaderInterface {
    companion object {
        const val HEADER_ITEM = 1
        const val SUB_ITEM = 2
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected var displayedItems: MutableList<Any> = ArrayList()

    @Suppress("MemberVisibilityCanBePrivate")
    protected lateinit var recyclerView: RecyclerView

    /**
     * Checks if current item is Header item
     */
    abstract fun isHeader(item: Any): Boolean

    /**
     * Method called when new ViewHolder needs to be created
     *
     * @param view  inflated view
     * @param viewType view type for which view holder should be created
     *
     * @return new viewHolder
     */
    abstract fun createViewHolder(view: View, viewType: Int): AbstractSectionViewHolder

    /**
     * Retrieve layout for [viewType]
     *
     * @param viewType view type for which layout is requested
     *
     * @return new viewHolder
     */
    @LayoutRes
    abstract fun getLayoutForViewType(viewType: Int): Int

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView

        items.observe(lifecycleOwner, Observer {
            updateItems(it)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractSectionViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(getLayoutForViewType(viewType), parent, false)

        return createViewHolder(v, viewType)
    }


    final override fun getItemViewType(position: Int): Int {
        if (isValidPosition(position)) {
            return getViewType(getItem(position))
        }
        return -1
    }

    final override fun onBindViewHolder(holder: AbstractSectionViewHolder, position: Int) {
        if (isValidPosition(position)) {
            holder.bind(getItem(position))
        }
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        for (i in itemPosition downTo 0) {
            if (isHeader(i)) {
                return i
            }
        }
        return 0
    }

    final override fun bindHeaderData(header: View, headerPosition: Int) {
        if (isValidPosition(headerPosition)) {
            val item = getItem(headerPosition)
            createViewHolder(header, getViewType(item)).bind(item)
        }
    }

    final override fun isHeader(itemPosition: Int): Boolean {
        if (isValidPosition(itemPosition)) {
            return isHeader(getItem(itemPosition))
        }
        return false
    }

    final override fun getHeaderLayout(headerPosition: Int): Int {
        return getLayoutForViewType(getViewType(getItem(headerPosition)))
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun isValidPosition(position: Int): Boolean = position in 0 until itemCount

    /**
     * Get view type of an [item]
     */
    protected open fun getViewType(item: Any): Int {
        return if (isHeader(item)) {
            HEADER_ITEM
        } else {
            SUB_ITEM
        }
    }

    @Synchronized
    protected fun updateItems(items: List<SectionItem<*, *>>) {
        displayedItems = ArrayList()
        extractSectionItems(items)
        submitList(displayedItems)
    }

    private fun extractSectionItems(items: List<Any>) {
        if (items.isEmpty()) return
        else if (items.first() is SectionItem<*, *>) {
            for (i in items) {
                val si = i as SectionItem<*, *>
                displayedItems.add(si.header)
                extractSectionItems(si.subItems)
            }
        } else {
            displayedItems.addAll(items)
        }
    }
}