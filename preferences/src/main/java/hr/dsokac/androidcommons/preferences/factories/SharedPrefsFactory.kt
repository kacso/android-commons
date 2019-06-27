package hr.dsokac.androidcommons.preferences.factories

import android.content.Context
import android.content.SharedPreferences
import hr.dsokac.androidcommons.preferences.ISharedPrefs
import hr.dsokac.androidcommons.preferences.impl.SharedPrefs

/**
 * Factory class which generates repositories available in preferences module
 *
 * @author Danijel Sokač
 */
object SharedPrefsFactory {
    private val prefs: MutableMap<String, ISharedPrefs> = HashMap()

    /**
     * Obtain instance of [ISharedPrefs] for given [name]. This method will ensure that there is
     * always only one instance of [ISharedPrefs] created for same [name].
     *
     * @param context App context used to create [SharedPreferences]
     * @param name name of [SharedPreferences] to be created
     *
     * @return instance of [ISharedPrefs]
     */
    @Synchronized
    fun getSharedPrefs(context: Context, name: String): ISharedPrefs {
        val pref = prefs[name]

        if (pref != null) {
            return pref
        }

        val newPref = SharedPrefs(context, name)
        prefs[name] = newPref
        return newPref
    }
}