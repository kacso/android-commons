package com.github.kacso.androidcommons.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.github.kacso.androidcommons.db.entities.UserEntity

@Dao
abstract class UserDao : BaseDao<UserEntity>() {
    @Query("SELECT * FROM ${UserEntity.TABLE_NAME} LIMIT 1")
    abstract fun getUser(): LiveData<UserEntity?>
}