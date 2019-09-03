package com.github.kacso.androidcommons.permissions.manager

import android.content.pm.PackageManager
import android.os.Build
import androidx.fragment.app.Fragment
import com.github.kacso.androidcommons.permissions.CAMERA_PERMISSIONS
import com.github.kacso.androidcommons.permissions.LOCATION_PERMISSIONS
import com.github.kacso.androidcommons.permissions.callbacks.PermissionCallback
import com.github.kacso.androidcommons.test.extensions.setSDK
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.ref.WeakReference
import java.util.concurrent.atomic.AtomicBoolean

class FragmentPermissionManagerTest {
    @Mock
    lateinit var fragment: Fragment

    lateinit var permissionManager: IPermissionManager

    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
        permissionManager = FragmentPermissionManager(WeakReference(fragment))
    }

    @Test
    fun allowedPermissionsPostM() {
        setSDK(Build.VERSION_CODES.M)

        val allowed = AtomicBoolean(false)
        val disallowed = AtomicBoolean(false)
        val requestCode = 100
        val requestedPermissions: Array<String> = LOCATION_PERMISSIONS

        permissionManager.requirePermissions(requestedPermissions, object : PermissionCallback {
            override fun onAllowed() {
                allowed.set(true)
            }

            override fun onDisallowed() {
                disallowed.set(true)
            }
        })

        val grantResults = IntArray(requestedPermissions.size)
        requestedPermissions.forEachIndexed { i, _ -> grantResults[i] = PackageManager.PERMISSION_GRANTED }
        permissionManager.onPermissionResult(requestCode, requestedPermissions, grantResults)

        Assertions.assertTrue(allowed.get())
        Assertions.assertFalse(disallowed.get())
    }

    @Test
    fun disallowedPermissionsPostM() {
        setSDK(Build.VERSION_CODES.M)

        val allowed = AtomicBoolean(false)
        val disallowed = AtomicBoolean(false)
        val requestCode = 100
        val requestedPermissions: Array<String> = LOCATION_PERMISSIONS

        permissionManager.requirePermissions(requestedPermissions, object : PermissionCallback {
            override fun onAllowed() {
                allowed.set(true)
            }

            override fun onDisallowed() {
                disallowed.set(true)
            }
        })

        val grantResults = IntArray(requestedPermissions.size)
        requestedPermissions.forEachIndexed { i, _ -> grantResults[i] = PackageManager.PERMISSION_DENIED }
        permissionManager.onPermissionResult(requestCode, requestedPermissions, grantResults)

        Assertions.assertFalse(allowed.get())
        Assertions.assertTrue(disallowed.get())
    }

    @Test
    fun partiallyAllowedPermissionsPostM() {
        setSDK(Build.VERSION_CODES.M)

        val allowed = AtomicBoolean(false)
        val disallowed = AtomicBoolean(false)
        val requestCode = 100
        val requestedPermissions: Array<String> = LOCATION_PERMISSIONS

        permissionManager.requirePermissions(requestedPermissions, object : PermissionCallback {
            override fun onAllowed() {
                allowed.set(true)
            }

            override fun onDisallowed() {
                disallowed.set(true)
            }
        })

        val grantResults = IntArray(requestedPermissions.size)
        requestedPermissions.forEachIndexed { i, _ -> grantResults[i] = PackageManager.PERMISSION_DENIED }
        grantResults[0] = PackageManager.PERMISSION_GRANTED
        permissionManager.onPermissionResult(requestCode, requestedPermissions, grantResults)

        Assertions.assertFalse(allowed.get())
        Assertions.assertTrue(disallowed.get())
    }

    @Test
    fun parallelRequestPostM() {
        setSDK(Build.VERSION_CODES.M)

        val allowed1 = AtomicBoolean(false)
        val disallowed1 = AtomicBoolean(false)
        val requestCode1 = 100
        val allowed2 = AtomicBoolean(false)
        val disallowed2 = AtomicBoolean(false)
        val requestCode2 = 101
        val requestedPermissions1: Array<String> = LOCATION_PERMISSIONS
        val requestedPermissions2: Array<String> = CAMERA_PERMISSIONS

        //Request location permissions
        permissionManager.requirePermissions(requestedPermissions1, object : PermissionCallback {
            override fun onAllowed() {
                allowed1.set(true)
            }

            override fun onDisallowed() {
                disallowed1.set(true)
            }
        })
        //grant all permissions
        val grantResults1 = IntArray(requestedPermissions1.size)
        requestedPermissions1.forEachIndexed { i, _ -> grantResults1[i] = PackageManager.PERMISSION_GRANTED }

        //request camera permissions
        permissionManager.requirePermissions(requestedPermissions1, object : PermissionCallback {
            override fun onAllowed() {
                allowed2.set(true)
            }

            override fun onDisallowed() {
                disallowed2.set(true)
            }
        })
        //deny all permissions
        val grantResults2 = IntArray(requestedPermissions2.size)
        requestedPermissions2.forEachIndexed { i, _ -> grantResults2[i] = PackageManager.PERMISSION_DENIED }

        //First notify about camera permissions, then about location
        permissionManager.onPermissionResult(requestCode2, requestedPermissions2, grantResults2)
        permissionManager.onPermissionResult(requestCode1, requestedPermissions1, grantResults1)


        //verify permissions
        Assertions.assertTrue(allowed1.get())
        Assertions.assertFalse(disallowed1.get())
        Assertions.assertFalse(allowed2.get())
        Assertions.assertTrue(disallowed2.get())
    }

    @Test
    fun allowedPermissionsPreM() {
        setSDK(Build.VERSION_CODES.LOLLIPOP_MR1)

        val allowed = AtomicBoolean(false)
        val disallowed = AtomicBoolean(false)
        val requestCode = 100
        val requestedPermissions: Array<String> = LOCATION_PERMISSIONS

        permissionManager.requirePermissions(requestedPermissions, object : PermissionCallback {
            override fun onAllowed() {
                allowed.set(true)
            }

            override fun onDisallowed() {
                disallowed.set(true)
            }
        })

        val grantResults = IntArray(requestedPermissions.size)
        requestedPermissions.forEachIndexed { i, _ -> grantResults[i] = PackageManager.PERMISSION_GRANTED }
        permissionManager.onPermissionResult(requestCode, requestedPermissions, grantResults)

        verify(fragment).onRequestPermissionsResult(requestCode, requestedPermissions, grantResults)
        Assertions.assertTrue(allowed.get())
        Assertions.assertFalse(disallowed.get())
    }
}