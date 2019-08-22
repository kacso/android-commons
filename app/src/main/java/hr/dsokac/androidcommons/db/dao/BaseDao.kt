package hr.dsokac.androidcommons.db.dao

import androidx.room.*

/**
 * Abstract DAO class which implements common functions of DAO objects
 *
 * @author Danijel Sokač
 */
abstract class BaseDao<T> {
    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     * @return The SQLite row id
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: T): Long

    /**
     * Insert an array of objects in the database.
     *
     * @param obj the objects to be inserted.
     * @return The SQLite row ids
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: List<T>): List<Long>

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    abstract fun update(obj: T)

    /**
     * Update an array of objects from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    abstract fun update(obj: List<T>)

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    abstract fun delete(obj: T)

    /**
     * Inserts [obj] to table, or if it already exists updates row
     *
     * @return ID of newly inserted row or -1 if row was updated
     */
    @Transaction
    open fun upsert(obj: T): Long {
        val res = insert(obj)
        if (res == -1L) {
            update(obj)
        }
        return res
    }

    /**
     * Inserts [objList] to table, or if some element in list already exists updates that row
     */
    @Transaction
    open fun upsert(objList: List<T>) {
        val resList = insert(objList)
        val updateList = ArrayList<T>()

        for (i in resList.indices) {
            if (resList[i] == -1L) {
                updateList.add(objList[i])
            }
        }

        if (!updateList.isEmpty()) {
            update(updateList)
        }
    }
}