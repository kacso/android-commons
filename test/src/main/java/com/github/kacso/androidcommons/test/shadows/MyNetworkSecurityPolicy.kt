package com.github.kacso.androidcommons.test.shadows

import android.os.Build
import android.security.NetworkSecurityPolicy
import androidx.annotation.RequiresApi
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements

/**
 * Use this as shadow when running network tests on SDK 21
 */
@Implements(NetworkSecurityPolicy::class)
class MyNetworkSecurityPolicy {
    @Implementation
    fun isCleartextTrafficPermitted(host: String): Boolean {
        return true
    }

    @Implementation
    fun isCleartextTrafficPermitted(): Boolean {
        return true
    }

    companion object {
        @RequiresApi(Build.VERSION_CODES.M)
        @Implementation
        @JvmStatic
        fun getInstance(): NetworkSecurityPolicy {
            try {
                val shadow =
                    Class.forName("android.security.NetworkSecurityPolicy")
                return shadow.newInstance() as NetworkSecurityPolicy
            } catch (e: Exception) {
                throw AssertionError()
            }

        }
    }
}