package com.github.kacso.androidcommons.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.kacso.androidcommons.core.BaseApplication
import com.github.kacso.androidcommons.db.dao.EntryDao
import com.github.kacso.androidcommons.db.dao.UserDao
import com.github.kacso.androidcommons.db.entities.EntryEntity
import com.github.kacso.androidcommons.db.entities.UserEntity

@Database(
    entities = [
        UserEntity::class, EntryEntity::class
    ], version = 1
)
@TypeConverters(value = [CustomTypeConverters::class])
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "AndroidCommons_DB"
        var user: String = ""

        private var instance: AppDatabase? = null
        fun getInstance(): AppDatabase {
            if (instance == null) {
                instance = createDB()
            }
            return instance!!
        }

        fun resetInstance(user: String = "") {
            this.user = user
            instance = null
        }

        private fun createDB(): AppDatabase {
            return Room
                .databaseBuilder(
                    BaseApplication.appContext,
                    AppDatabase::class.java,
                    "$DATABASE_NAME-$user"
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun getUserDao(): UserDao
    abstract fun getEntryDao(): EntryDao
}