package com.github.kacso.androidcommons.preferences.impl

import com.github.kacso.androidcommons.preferences.ISharedPrefs
import com.github.kacso.androidcommons.preferences.factories.SharedPrefsFactory
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [23])
class SharedPrefsTest {
    private lateinit var prefs: ISharedPrefs
    private val PREF_NAME = "prefs"

    @Before
    fun setup() {
        prefs = SharedPrefsFactory.getSharedPrefs(RuntimeEnvironment.systemContext, PREF_NAME)
    }

    @After
    fun tearDown() {
        prefs.getPreferences().edit().clear().apply()
    }

    @Test
    fun getPreferences() {
        val p = prefs.getPreferences()

        val valueKey = "KEY"
        val value = "value"
        p.edit().putString(valueKey, value).apply()

        Assertions.assertEquals(value, p.getString(valueKey, ""))
    }

    @Test
    fun getName() {
        Assertions.assertEquals(
            RuntimeEnvironment.systemContext.packageName + "_" + PREF_NAME,
            prefs.getName()
        )
    }

    @Test
    fun saveInt() {
        val key = "KEY"
        val value = 1

        Assertions.assertEquals(0, prefs.read(key, 0))
        prefs.write(key, value)
        Assertions.assertEquals(value, prefs.read(key, 0))

        prefs.removeKey(key)
        Assertions.assertEquals(0, prefs.read(key, 0))
    }

    @Test
    fun saveFloat() {
        val key = "KEY"
        val value = 1f

        Assertions.assertEquals(0f, prefs.read(key, 0f))
        prefs.write(key, value)
        Assertions.assertEquals(value, prefs.read(key, 0f))

        prefs.removeKey(key)
        Assertions.assertEquals(0f, prefs.read(key, 0f))
    }

    @Test
    fun saveLong() {
        val key = "KEY"
        val value = 1L

        Assertions.assertEquals(0L, prefs.read(key, 0L))
        prefs.write(key, value)
        Assertions.assertEquals(value, prefs.read(key, 0L))

        prefs.removeKey(key)
        Assertions.assertEquals(0L, prefs.read(key, 0L))
    }

    @Test
    fun saveString() {
        val key = "KEY"
        val value = "value"

        Assertions.assertNull(prefs.read(key, null as String?))
        prefs.write(key, value)
        Assertions.assertEquals(value, prefs.read(key, ""))

        prefs.removeKey(key)
        Assertions.assertNull(prefs.read(key, null as String?))
    }

    @Test
    fun saveStringSet() {
        val key = "KEY"
        val value = setOf("value1", "value2")

        Assertions.assertNull(prefs.read(key, null as Set<String>?))
        prefs.write(key, value)
        Assertions.assertEquals(value, prefs.read(key, null as Set<String>?))

        prefs.removeKey(key)
        Assertions.assertNull(prefs.read(key, null as Set<String>?))
    }

    @Test
    fun saveBoolean() {
        val key = "KEY"
        val value = true

        Assertions.assertEquals(false, prefs.read(key, false))
        prefs.write(key, value)
        Assertions.assertEquals(value, prefs.read(key, false))

        prefs.removeKey(key)
        Assertions.assertEquals(false, prefs.read(key, false))
    }
}