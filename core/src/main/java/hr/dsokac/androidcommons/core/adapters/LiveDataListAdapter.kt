package hr.dsokac.androidcommons.core.adapters

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
import hr.dsokac.androidcommons.core.adapters.utils.DefaultDiffUtilsItemCallback
import hr.dsokac.androidcommons.core.adapters.viewholders.BaseViewHolder

/**
 * Abstract implementation of [RecyclerView.Adapter] which works with [LiveData] list.
 * This adapter will automatically update list when live data emit changes.
 *
 * @param T     Type of single list item
 * @param VH    ViewHolder type
 * @property items list of items to be shown, wrapped in [LiveData]
 * @property lifecycleOwner    lifecycle owner on which list modifications will be observed
 */
abstract class LiveDataListAdapter<T : Any, VH : BaseViewHolder<T>>(
    private val items: LiveData<List<T>>,
    private val lifecycleOwner: LifecycleOwner,
    diffUtilCallback: DiffUtil.ItemCallback<T> = DefaultDiffUtilsItemCallback()
) : ListAdapter<T, VH>(diffUtilCallback) {
    @Suppress("MemberVisibilityCanBePrivate")
    protected lateinit var recyclerView: RecyclerView

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
    @LayoutRes
    abstract fun getItemLayout(): Int

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView

        items.observe(lifecycleOwner, Observer {
            submitList(it)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(getItemLayout(), parent, false)

        return createViewHolder(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}