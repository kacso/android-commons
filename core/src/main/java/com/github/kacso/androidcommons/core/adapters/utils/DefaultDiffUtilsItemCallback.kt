package com.github.kacso.androidcommons.core.adapters.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

open class DefaultDiffUtilsItemCallback<T> : DiffUtil.ItemCallback<T>() {
    /**
     * Default implementation, equality is checked by reference
     */
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem === newItem
    }

    /**
     * Default implementation, equality is checked using equals function
     */
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}