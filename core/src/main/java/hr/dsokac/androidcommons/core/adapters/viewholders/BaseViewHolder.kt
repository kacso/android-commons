package hr.dsokac.androidcommons.core.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.dsokac.androidcommons.core.adapters.LiveDataListAdapter
import hr.dsokac.androidcommons.core.adapters.PagedLiveDataListAdapter

/**
 * Abstract ViewHolder class defining methods required by [LiveDataListAdapter] and [PagedLiveDataListAdapter]
 *
 * @author Danijel Sokač
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /**
     * Method called to initialize UI with item data
     */
    abstract fun bind(item: T)
}