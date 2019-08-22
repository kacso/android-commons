package hr.dsokac.androidcommons.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import hr.dsokac.androidcommons.core.repository.NetworkBoundResource
import hr.dsokac.androidcommons.db.dao.UserDao
import hr.dsokac.androidcommons.mappers.toEntity
import hr.dsokac.androidcommons.mappers.toUser
import hr.dsokac.androidcommons.models.network.ApiUser
import hr.dsokac.androidcommons.models.ui.User
import hr.dsokac.androidcommons.network.models.ApiResponse
import hr.dsokac.androidcommons.network.services.AppService
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