package hr.dsokac.androidcommons.location

import android.Manifest
import android.content.Context
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.annotation.RequiresPermission
import hr.dsokac.androidcommons.location.exceptions.LocationDisabledException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


/**
 * Class which is used to retrieve current user location with one request.
 */
object SingleShotLocationProvider {
    /**
     * Function to retrieve single location update.
     *
     * @param context current context of an app
     *
     * @return User last known location
     */
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    suspend fun requestSingleUpdate(context: Context): Location {
        return suspendCoroutine { cont ->
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                val criteria = Criteria()
                criteria.accuracy = Criteria.ACCURACY_FINE
                locationManager.requestSingleUpdate(criteria, object : LocationListener {
                    override fun onLocationChanged(location: Location) {
                        cont.resume(location)
                    }

                    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
                    override fun onProviderEnabled(provider: String) {}
                    override fun onProviderDisabled(provider: String) {}
                }, null)
            } else if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                //use this to retrieve location from network instead of GPS (more battery friendly)
                val criteria = Criteria()
                criteria.accuracy = Criteria.ACCURACY_COARSE
                locationManager.requestSingleUpdate(criteria, object : LocationListener {
                    override fun onLocationChanged(location: Location) {
                        cont.resume(location)
                    }

                    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
                    override fun onProviderEnabled(provider: String) {}
                    override fun onProviderDisabled(provider: String) {}
                }, null)
            } else {
                cont.resumeWithException(LocationDisabledException())
            }
        }
    }
}