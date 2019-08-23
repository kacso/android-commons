package hr.dsokac.androidcommons.mappers

import hr.dsokac.androidcommons.db.entities.EntryEntity
import hr.dsokac.androidcommons.models.network.ApiEntry
import hr.dsokac.androidcommons.models.ui.Entry

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