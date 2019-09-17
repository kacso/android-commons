package com.github.kacso.androidcommons.location

import android.Manifest
import android.content.Context
import android.location.Location
import android.os.Looper
import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.kacso.androidcommons.data.ErrorHolder
import com.github.kacso.androidcommons.data.Resource
import com.github.kacso.androidcommons.location.exceptions.LocationDisabledException
import com.google.android.gms.location.*
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Use this class to retrieve real-time location updates.
 * Location updates are emitted through [LiveData] inside [Resource] model.
 * This class makes sure that location updates are generated only when there are active observers.
 *
 * @param context App active context
 * @param locationRequest A data object that contains quality of service parameters for location updates.
 */
class LocationProvider(
    context: Context,
    private val locationRequest: LocationRequest = LocationRequest.create()
) {
    private val provider = FusedLocationProviderClient(context)
    private val locationLd: MutableLiveData<Resource<Location>> = object : MutableLiveData<Resource<Location>>() {
        private var started = AtomicBoolean(false)
        override fun onActive() {
            super.onActive()
            if (started.compareAndSet(false, true)) {
                provider.requestLocationUpdates(
                    locationRequest,
                    locationCallback,
                    Looper.getMainLooper()
                )
            }
        }

        override fun onInactive() {
            super.onInactive()
            if (started.compareAndSet(true, false)) {
                provider.removeLocationUpdates(locationCallback)
            }
        }
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(res: LocationResult?) {
            res?.lastLocation?.let {
                locationLd.postValue(Resource.Success(it))
            }
        }

        override fun onLocationAvailability(availability: LocationAvailability?) {
            if (availability?.isLocationAvailable == false) {
                locationLd.postValue(
                    Resource.Error(
                        ErrorHolder(
                            message = "Location not available. Action required by user to obtain location again.",
                            cause = LocationDisabledException()
                        )
                    )
                )
            }
        }
    }

    /**
     * Retrieve [LiveData] object on which [Location] or [ErrorHolder] will be emitted
     *
     * @return [LiveData] on which [Location] will be emitted
     */
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getLocation(): LiveData<Resource<Location>> {
        return locationLd
    }
}