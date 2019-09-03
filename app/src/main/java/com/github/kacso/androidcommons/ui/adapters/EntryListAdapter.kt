package com.github.kacso.androidcommons.ui.adapters

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.adapters.LiveDataListAdapter
import com.github.kacso.androidcommons.core.adapters.viewholders.BaseViewHolder
import com.github.kacso.androidcommons.extensions.toLocalDateTime
import com.github.kacso.androidcommons.models.ui.Entry
import kotlinx.android.synthetic.main.item_entry.view.*
import org.threeten.bp.format.DateTimeFormatter

class EntryListAdapter(
    items: LiveData<List<Entry>>,
    lifecycleOwner: LifecycleOwner
) : LiveDataListAdapter<Entry, EntryListAdapter.ViewHolder>(
    items,
    lifecycleOwner,
    EntryDiffItemCallback
) {
    override fun createViewHolder(view: View): ViewHolder {
        return ViewHolder(view)
    }

    override val itemLayoutRes: Int = R.layout.item_entry

    object EntryDiffItemCallback : DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem.date == newItem.date && oldItem.value == newItem.value
        }

    }

    class ViewHolder(itemView: View) : BaseViewHolder<Entry>(itemView) {
        override fun bind(item: Entry) {
            itemView.date.text =
                item.date.toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)

            itemView.value.text = item.value
        }
    }
}