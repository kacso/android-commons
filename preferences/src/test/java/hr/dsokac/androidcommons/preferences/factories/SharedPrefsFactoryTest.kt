package hr.dsokac.androidcommons.preferences.factories

import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [23])
class SharedPrefsFactoryTest {
    @Test
    fun getSharedPrefs() {
        val pref1 = SharedPrefsFactory.getSharedPrefs(RuntimeEnvironment.systemContext, "pref1")
        val pref2 = SharedPrefsFactory.getSharedPrefs(RuntimeEnvironment.systemContext, "pref2")

        Assertions.assertNotEquals(pref1, pref2)

        Assertions.assertEquals(pref1, SharedPrefsFactory.getSharedPrefs(RuntimeEnvironment.systemContext, "pref1"))
        Assertions.assertEquals(pref2, SharedPrefsFactory.getSharedPrefs(RuntimeEnvironment.systemContext, "pref2"))
    }
}