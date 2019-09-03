package com.github.kacso.androidcommons.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.github.kacso.androidcommons.core.repository.NetworkBoundResource
import com.github.kacso.androidcommons.db.dao.UserDao
import com.github.kacso.androidcommons.mappers.toEntity
import com.github.kacso.androidcommons.mappers.toUser
import com.github.kacso.androidcommons.models.network.ApiUser
import com.github.kacso.androidcommons.models.ui.User
import com.github.kacso.androidcommons.network.models.ApiResponse
import com.github.kacso.androidcommons.network.services.AppService
import kotlin.coroutines.suspendCoroutine

class UserResource(
    private val userDao: UserDao,
    private val service: AppService
) : NetworkBoundResource<User, ApiUser>() {
    override suspend fun saveCallResult(item: ApiUser) {
        return suspendCoroutine {
            userDao.upsert(item.toEntity())
        }
    }

    override fun loadFromDb(): LiveData<User> {
        return Transformations.map(userDao.getUser()) {
            it?.toUser()
        }
    }

    override fun createCall(): LiveData<ApiResponse<ApiUser>> {
        return service.getUserInfo()
    }

    override fun shouldFetch(data: User?): Boolean = true
}