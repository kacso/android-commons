package hr.dsokac.androidcommons.test.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.jupiter.api.Assertions
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Test value from LiveData by waiting up to 2 seconds until it is emitted
 *
 * @param expected Expected value returned from LiveData
 */
fun <T> LiveData<T>.test(expected: T) {
    Assertions.assertEquals(expected, getTestValue())
}

/**
 * Get value from LiveData by waiting up to 2 seconds until it is emitted
 */
fun <T> LiveData<T>.getTestValue(): T {
    val data = arrayOfNulls<Any>(1)
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data[0] = o
            latch.countDown()
            removeObserver(this)
        }
    }
    observeForever(observer)
    latch.await(2, TimeUnit.SECONDS)

    @Suppress("UNCHECKED_CAST")
    return data[0] as T
}