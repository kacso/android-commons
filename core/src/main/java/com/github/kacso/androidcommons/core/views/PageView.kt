package com.github.kacso.androidcommons.core.views

import androidx.annotation.StringRes

/**
 * Interface which defines basic functionalities of single page of [PagerView]
 *
 * @author Danijel Sokač
 */
interface PageView {
    /**
     * Function to retrieve title of page
     *
     * @return string representing page title
     */
    @StringRes
    fun getTitleRes(): Int
}