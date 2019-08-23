package hr.dsokac.androidcommons.ui.adapters

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import hr.dsokac.androidcommons.R
import hr.dsokac.androidcommons.core.adapters.PagedLiveDataListAdapter
import hr.dsokac.androidcommons.core.adapters.viewholders.BaseViewHolder
import hr.dsokac.androidcommons.extensions.toLocalDateTime
import hr.dsokac.androidcommons.models.ui.Entry
import kotlinx.android.synthetic.main.item_entry.view.*
import org.threeten.bp.format.DateTimeFormatter

class EntryPageListAdapter(
    items: LiveData<PagedList<Entry>>,
    lifecycleOwner: LifecycleOwner
) : PagedLiveDataListAdapter<Entry, EntryPageListAdapter.ViewHolder>(
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