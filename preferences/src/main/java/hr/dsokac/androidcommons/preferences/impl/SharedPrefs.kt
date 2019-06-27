package hr.dsokac.androidcommons.preferences.impl

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import hr.dsokac.androidcommons.preferences.ISharedPrefs

/**
 * Default implementation of [ISharedPrefs]
 *
 * @author Danijel Sokač
 */
class SharedPrefs(
    context: Context,
    prefName: String
) : ISharedPrefs {
    private val prefFullName: String = context.packageName + "_" + prefName
    private val sharedPreferences = context.getSharedPreferences(prefFullName, Activity.MODE_PRIVATE)

    override fun getPreferences(): SharedPreferences = sharedPreferences

    override fun read(key: String, defValue: String?): String? = sharedPreferences.getString(key, defValue)

    override fun write(key: String, value: String) {
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

    override fun read(key: String, defValue: Set<String>?): Set<String>? = sharedPreferences.getStringSet(key, defValue)

    override fun write(key: String, value: Set<String>) {
        sharedPreferences.edit()
            .putStringSet(key, value)
            .apply()
    }

    override fun read(key: String, defValue: Boolean): Boolean = sharedPreferences.getBoolean(key, defValue)

    override fun write(key: String, value: Boolean) {
        sharedPreferences.edit()
            .putBoolean(key, value)
            .apply()
    }

    override fun read(key: String, defValue: Int): Int = sharedPreferences.getInt(key, defValue)

    override fun write(key: String, value: Int) {
        sharedPreferences.edit()
            .putInt(key, value)
            .apply()
    }

    override fun read(key: String, defValue: Long): Long = sharedPreferences.getLong(key, defValue)

    override fun write(key: String, value: Long) {
        sharedPreferences.edit()
            .putLong(key, value)
            .apply()
    }

    override fun read(key: String, defValue: Float): Float = sharedPreferences.getFloat(key, defValue)

    override fun write(key: String, value: Float) {
        sharedPreferences.edit()
            .putFloat(key, value)
            .apply()
    }

    override fun getName(): String = prefFullName

    override fun removeKey(key: String) {
        sharedPreferences.edit()
            .remove(key)
            .apply()
    }
}