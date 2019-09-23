package com.github.kacso.androidcommons.core.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Abstract class which defines basic functionality of ViewHolder used in {@link AbstractSectionAdapter}
 */
abstract class AbstractSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Any)
}