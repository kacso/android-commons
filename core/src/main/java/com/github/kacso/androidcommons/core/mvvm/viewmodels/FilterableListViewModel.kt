package com.github.kacso.androidcommons.core.mvvm.viewmodels

/**
 * [ListViewModel] which handles filtering
 *
 * @author Danijel Sokač
 */
abstract class FilterableListViewModel<T, S> : ListViewModel<T>() {
    /**
     * Current filter set by user
     */
    var filterTerm: S? = null
        set(value) {
            field = value
            refreshData()
        }
}