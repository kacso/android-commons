package com.github.kacso.androidcommons.models.ui

import java.util.*

data class User(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String
) {
    override fun toString(): String {
        return "$firstName $lastName"
    }
}