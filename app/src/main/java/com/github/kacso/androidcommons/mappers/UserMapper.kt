package com.github.kacso.androidcommons.mappers

import com.github.kacso.androidcommons.db.entities.UserEntity
import com.github.kacso.androidcommons.models.network.ApiUser
import com.github.kacso.androidcommons.models.ui.User
import java.util.*

fun ApiUser.toEntity(): UserEntity {
    return UserEntity(
        id = UUID.fromString(id),
        firstName = firstName,
        lastName = lastName,
        email = email
    )
}

fun UserEntity.toUser(): User {
    return User(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email
    )
}