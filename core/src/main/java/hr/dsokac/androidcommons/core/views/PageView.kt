package hr.dsokac.androidcommons.core.views

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
    fun getTitle(): String
}