package hr.dsokac.androidcommons.location

import android.Manifest
import android.content.Context
import android.location.Location
import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import com.google.android.gms.location.*
import hr.dsokac.androidcommons.core.livedata.ObserverAwareLiveData
import hr.dsokac.androidcommons.data.ErrorHolder
import hr.dsokac.androidcommons.data.Resource
import hr.dsokac.androidcommons.location.exceptions.LocationDisabledException

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
    private val locationLd = ObserverAwareLiveData<Resource<Location>>()

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

    init {
        locationLd.addActiveStatusObserver(object : ObserverAwareLiveData.ActiveStatusObserver {
            override fun onActive() {
                provider.requestLocationUpdates(locationRequest, locationCallback, null)
            }

            override fun onInactive() {
                provider.removeLocationUpdates(locationCallback)
            }
        })
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