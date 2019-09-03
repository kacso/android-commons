package com.github.kacso.androidcommons.extensions

import android.widget.TextView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.github.kacso.androidcommons.test.lifecycle.TestLifecycleOwner
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
class TextViewExtensionsTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val lifecycleOwner: LifecycleOwner = TestLifecycleOwner()

    @Test
    fun setLiveText() {
        val ld = MutableLiveData<String>()
        ld.value = "Text1"

        val textView = TextView(RuntimeEnvironment.systemContext)

        textView.setLiveText(lifecycleOwner, ld)

        Assertions.assertEquals("Text1", textView.text)
        ld.value = "Text2"
        Assertions.assertEquals("Text2", textView.text)
    }

    //TODO test HTML
}