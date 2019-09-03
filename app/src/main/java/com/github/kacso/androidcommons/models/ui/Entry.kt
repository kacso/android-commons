package com.github.kacso.androidcommons.models.ui

import org.threeten.bp.Instant

data class Entry(
    val id: Long,
    val date: Instant,
    val value: String
) {
    override fun equals(other: Any?): Boolean {
        if (other is Entry) {
            return other.id == id
        }

        return false
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}