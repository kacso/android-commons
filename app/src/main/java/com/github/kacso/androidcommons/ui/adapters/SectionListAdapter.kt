package com.github.kacso.androidcommons.ui.adapters

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.github.kacso.androidcommons.R
import com.github.kacso.androidcommons.core.adapters.AbstractSectionListAdapter
import com.github.kacso.androidcommons.core.adapters.models.SectionItem
import com.github.kacso.androidcommons.core.adapters.viewholders.AbstractSectionViewHolder
import com.github.kacso.androidcommons.models.ui.sectionitems.Header1
import com.github.kacso.androidcommons.models.ui.sectionitems.Header2
import com.github.kacso.androidcommons.models.ui.sectionitems.SubItem1
import com.github.kacso.androidcommons.models.ui.sectionitems.SubItem2
import kotlinx.android.synthetic.main.item_header1.view.name as header1Name
import kotlinx.android.synthetic.main.item_header2.view.name as header2Name
import kotlinx.android.synthetic.main.item_subitem1.view.name as subItem1Name
import kotlinx.android.synthetic.main.item_subitem2.view.name as subItem2Name

class SectionListAdapter(
    items: LiveData<List<SectionItem<*, *>>>,
    lifecycleOwner: LifecycleOwner
) : AbstractSectionListAdapter(items, lifecycleOwner) {
    companion object {
        const val HEADER_1_ITEM = 1
        const val HEADER_2_ITEM = 2
        const val SUB_ITEM_1 = 3
        const val SUB_ITEM_2 = 4
    }

    override fun isHeader(item: Any): Boolean = item is Header1 || item is Header2

    override fun createViewHolder(view: View, viewType: Int): AbstractSectionViewHolder {
        return when (viewType) {
            HEADER_1_ITEM -> Header1ViewHolder(view)
            HEADER_2_ITEM -> Header2ViewHolder(view)
            SUB_ITEM_1 -> SubItem1ViewHolder(view)
            SUB_ITEM_2 -> SubItem2ViewHolder(view)
            else -> throw TypeNotPresentException("View type ($viewType) not supported", null)
        }
    }

    override fun getLayoutForViewType(viewType: Int): Int {
        return when (viewType) {
            HEADER_1_ITEM -> R.layout.item_header1
            HEADER_2_ITEM -> R.layout.item_header2
            SUB_ITEM_1 -> R.layout.item_subitem1
            SUB_ITEM_2 -> R.layout.item_subitem2
            else -> throw TypeNotPresentException("View type ($viewType) not supported", null)
        }
    }

    override fun getViewType(item: Any): Int {
        return when (item) {
            is Header1 -> HEADER_1_ITEM
            is Header2 -> HEADER_2_ITEM
            is SubItem1 -> SUB_ITEM_1
            is SubItem2 -> SUB_ITEM_2
            else -> throw TypeNotPresentException("Item ($item) not supported", null)
        }
    }

    class Header1ViewHolder(itemView: View) : AbstractSectionViewHolder(itemView) {
        override fun bind(item: Any) {
            if (item !is Header1) return

            itemView.header1Name.text = item.name
        }
    }

    class Header2ViewHolder(itemView: View) : AbstractSectionViewHolder(itemView) {
        override fun bind(item: Any) {
            if (item !is Header2) return

            itemView.header2Name.text = item.name
        }
    }

    class SubItem1ViewHolder(itemView: View) : AbstractSectionViewHolder(itemView) {
        override fun bind(item: Any) {
            if (item !is SubItem1) return

            itemView.subItem1Name.text = item.name
        }
    }

    class SubItem2ViewHolder(itemView: View) : AbstractSectionViewHolder(itemView) {
        override fun bind(item: Any) {
            if (item !is SubItem2) return

            itemView.subItem2Name.text = item.name
        }
    }
}