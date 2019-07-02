package hr.dsokac.androidcommons.extensions

import android.widget.CheckBox
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import hr.dsokac.androidcommons.test.lifecycle.TestLifecycleOwner
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [23])
class CheckboxExtensionsTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val lifecycleOwner: LifecycleOwner = TestLifecycleOwner()

    @Test
    fun setLiveChecked() {
        val ld = MutableLiveData<Boolean>()
        ld.value = true

        val checkbox = CheckBox(RuntimeEnvironment.systemContext)

        checkbox.setLiveChecked(lifecycleOwner, ld)

        Assertions.assertTrue(checkbox.isChecked)
        ld.value = false
        Assertions.assertFalse(checkbox.isChecked)
    }
}