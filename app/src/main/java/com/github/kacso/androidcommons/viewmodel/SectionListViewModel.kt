package com.github.kacso.androidcommons.viewmodel

import com.github.kacso.androidcommons.core.adapters.models.SectionItem
import com.github.kacso.androidcommons.core.mvvm.viewmodels.ListViewModel
import com.github.kacso.androidcommons.models.ui.sectionitems.Header1
import com.github.kacso.androidcommons.models.ui.sectionitems.Header2
import com.github.kacso.androidcommons.models.ui.sectionitems.SubItem1
import com.github.kacso.androidcommons.models.ui.sectionitems.SubItem2

class SectionListViewModel : ListViewModel<SectionItem<*, *>>() {
    override fun refreshData(forceRefresh: Boolean) {
        isProgressActive.postValue(true)
        liveData.postValue(
            listOf(
                SectionItem(
                    Header1("Header1.1"),
                    listOf(
                        SectionItem(
                            Header2("Header2.1"),
                            listOf(
                                SubItem1("SubItem1.1"),
                                SubItem2("SubItem2.1"),
                                SubItem1("SubItem1.2")
                            )
                        ),
                        SectionItem(
                            Header2("Header2.2"),
                            listOf(
                                SubItem1("SubItem1.3"),
                                SubItem2("SubItem2.2"),
                                SubItem1("SubItem1.4")
                            )
                        ),
                        SectionItem(
                            Header2("Header2.3"),
                            listOf(
                                SubItem1("SubItem1.5"),
                                SubItem2("SubItem2.3"),
                                SubItem1("SubItem1.6")
                            )
                        )
                    )
                ),
                SectionItem(
                    Header1("Header1.2"),
                    listOf(
                        SectionItem(
                            Header2("Header2.4"),
                            listOf(
                                SubItem1("SubItem1.7"),
                                SubItem2("SubItem2.3"),
                                SubItem1("SubItem1.8")
                            )
                        )
                    )
                ),
                SectionItem(
                    Header1("Header1.3"),
                    listOf(
                        SectionItem(
                            Header2("Header2.5"),
                            listOf(
                                SubItem1("SubItem2.4")
                            )
                        ),
                        SectionItem(
                            Header2("Header2.6"),
                            listOf(
                                SubItem1("SubItem2.5"),
                                SubItem2("SubItem2.6"),
                                SubItem1("SubItem1.9")
                            )
                        )
                    )
                )
            )
        )
        isProgressActive.postValue(false)
    }

}