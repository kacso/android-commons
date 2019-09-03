package com.github.kacso.androidcommons.preferences

import android.content.SharedPreferences

/**
 * Interface defining basic functionalities that subclasses needs to implement to wrap [SharedPreferences] calls.
 * This util is used to remove boilerplate from the user when using [SharedPreferences].
 *
 * @author Danijel Sokač
 */
interface ISharedPrefs {
    /**
     * Get [SharedPreferences]
     */
    fun getPreferences(): SharedPreferences

    /**
     * Reads a string value
     *
     * @param key      preference key
     * @param defValue default expected value
     * @return [SharedPreferences] value, or [defValue] if not found
     */
    fun read(key: String, defValue: String?): String?

    /**
     * Writes a string value into [SharedPreferences]
     *
     * @param key   preference key for identification
     * @param value value to write
     */
    fun write(key: String, value: String)

    /**
     * Reads a set of strings
     *
     * @param key      preference key
     * @param defValue default expected value
     * @return [SharedPreferences] value, or [defValue] if not found
     */
    fun read(key: String, defValue: Set<String>?): Set<String>?

    /**
     * Writes a set of strings into [SharedPreferences]
     *
     * @param key   preference key for identification
     * @param value value to write
     */
    fun write(key: String, value: Set<String>)

    /**
     * Reads a boolean value
     *
     * @param key      preference key
     * @param defValue default expected value
     * @return [SharedPreferences] value, or [defValue] if not found
     */
    fun read(key: String, defValue: Boolean): Boolean

    /**
     * Writes a boolean value into [SharedPreferences]
     *
     * @param key   preference key for identification
     * @param value value to write
     */
    fun write(key: String, value: Boolean)

    /**
     * Reads an integer value
     *
     * @param key      preference key
     * @param defValue default expected value
     * @return [SharedPreferences] value, or [defValue] if not found
     */
    fun read(key: String, defValue: Int): Int

    /**
     * Writes an integer value into [SharedPreferences]
     *
     * @param key   preference key for identification
     * @param value value to write
     */
    fun write(key: String, value: Int)

    /**
     * Reads an long value
     *
     * @param key      preference key
     * @param defValue default expected value
     * @return [SharedPreferences] value, or [defValue] if not found
     */
    fun read(key: String, defValue: Long): Long

    /**
     * Writes an long value into [SharedPreferences]
     *
     * @param key   preference key for identification
     * @param value value to write
     */
    fun write(key: String, value: Long)

    /**
     * Reads an float value
     *
     * @param key      preference key
     * @param defValue default expected value
     * @return [SharedPreferences] value, or [defValue] if not found
     */
    fun read(key: String, defValue: Float): Float

    /**
     * Writes an float value into [SharedPreferences]
     *
     * @param key   preference key for identification
     * @param value value to write
     */
    fun write(key: String, value: Float)

    /**
     * @return name of this preference file
     */
    fun getName(): String

    /**
     * Removes key from [SharedPreferences]
     *
     * @param key preference key for identification
     */
    fun removeKey(key: String)
}