package hr.dsokac.androidcommons.extensions

import org.junit.Test
import org.junit.jupiter.api.Assertions

class DoubleExtensionsTest {
    @Test
    fun testFormatter() {
        val PI = 3.14159265359

        Assertions.assertEquals("3", PI.format(0))
        Assertions.assertEquals("3.14", PI.format(2))
        Assertions.assertEquals("3.141592653590000", PI.format(15))
    }
}