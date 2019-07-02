package hr.dsokac.androidcommons.permissions.manager

import android.content.pm.PackageManager
import android.os.Build
import androidx.collection.SparseArrayCompat
import androidx.fragment.app.FragmentActivity
import hr.dsokac.androidcommons.permissions.callbacks.PermissionCallback
import java.lang.ref.WeakReference

/**
 * [IPermissionManager] implementation used on [FragmentActivity]
 *
 * @property activityRef [WeakReference] to [FragmentActivity] on which permissions will be requested
 *
 * @author Danijel Sokač
 */
class ActivityPermissionManager(
    private val activityRef: WeakReference<FragmentActivity>
) : IPermissionManager {
    private val callbacks: SparseArrayCompat<PermissionCallback> = SparseArrayCompat()

    private val requestIdIterator = object : Iterator<Int> {
        private var current = 100

        override fun hasNext(): Boolean {
            return true
        }

        override fun next(): Int {
            return current++
        }
    }

    override fun requirePermissions(permissions: Array<String>, callback: PermissionCallback): Int {
        val requestId = requestIdIterator.next()
        requirePermissions(permissions, requestId)
        callbacks.put(requestId, callback)
        return requestId
    }

    override fun onPermissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        val callback = callbacks.get(requestCode) ?: return

        for (grantResult in grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                callback.onDisallowed()
                return
            }
        }

        callback.onAllowed()
    }

    private fun requirePermissions(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activityRef.get()?.requestPermissions(permissions, requestCode)
        } else {
            val res = IntArray(permissions.size) {
                PackageManager.PERMISSION_GRANTED
            }
            activityRef.get()?.onRequestPermissionsResult(requestCode, permissions, res)
        }
    }
}