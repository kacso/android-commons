package com.github.kacso.androidcommons.extensions.fragments

interface IExtendedFragment {
    /**
     * Called when child fragment is popped from backstack. Override this method if any additional
     * actions are required by parent fragment
     */
    fun onChildFragmentBack()
}