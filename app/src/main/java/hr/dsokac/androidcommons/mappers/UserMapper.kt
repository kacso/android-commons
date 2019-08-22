package hr.dsokac.androidcommons.mappers

import hr.dsokac.androidcommons.db.entities.UserEntity
import hr.dsokac.androidcommons.models.network.ApiUser
import hr.dsokac.androidcommons.models.ui.User
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