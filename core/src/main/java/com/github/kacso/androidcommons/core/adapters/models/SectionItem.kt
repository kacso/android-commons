package com.github.kacso.androidcommons.core.adapters.models

import com.github.kacso.androidcommons.core.adapters.AbstractSectionListAdapter

/**
 *
 * Class used to display section in listview. Use it in combination with [AbstractSectionListAdapter]
 *
 *  @param H         object defining header
 *  @param SI        object defining section items
 *  @param header    instance of {@link H} which holds details about header
 *  @param subItems  list of {@link SI} which holds details about section items
 */
data class SectionItem<H : Any, SI : Any>(var header: H, var subItems: List<SI>)

/**
 * Mapper function, which maps map of header and list of subitems to SectionItem list
 * in order to support @{AbstractSectionAdapter}
 *
 * @param H     object defining header
 * @param SI    object defining section items
 *
 * @return  list of selection items
 */
fun <H : Any, SI : Any> Map<H, List<SI>>.toSectionItemListmap(): List<SectionItem<H, SI>> {
    val l = ArrayList<SectionItem<H, SI>>()

    for (e in this) {
        l.add(SectionItem(e.key, e.value))
    }
    return l
}