package com.github.kacso.androidcommons.mappers

import com.github.kacso.androidcommons.db.entities.EntryEntity
import com.github.kacso.androidcommons.models.network.ApiEntry
import com.github.kacso.androidcommons.models.ui.Entry

fun ApiEntry.toEntity(): EntryEntity {
    return EntryEntity(
        id = id,
        date = date,
        value = value
    )
}

fun EntryEntity.toEntry(): Entry {
    return Entry(
        id = id,
        date = date,
        value = value
    )
}