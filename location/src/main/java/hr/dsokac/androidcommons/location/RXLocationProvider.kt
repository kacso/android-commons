package hr.dsokac.androidcommons.location

import android.Manifest
import android.content.Context
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.*
import hr.dsokac.androidcommons.location.exceptions.LocationDisabledException
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Use this class to retrieve real-time location updates.
 * Location updates are emitted through [Observable].
 * This class makes sure that location updates are stopped once source is disposed.
 *
 * @param context App active context
 * @param locationRequest A data object that contains quality of service parameters for location updates.
 */
class RXLocationProvider(
    private val context: Context,
    private val locationRequest: LocationRequest = LocationRequest.create()
) {
    private val provider = FusedLocationProviderClient(context)
    private val locationObservable = BehaviorSubject.create<Location>()

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(res: LocationResult?) {
            res?.lastLocation?.let {
                locationObservable.onNext(it)
            }
        }

        override fun onLocationAvailability(availability: LocationAvailability?) {
            if (availability?.isLocationAvailable == false) {
                locationObservable.onError(LocationDisabledException())
            }
        }
    }

    /**
     * Retrieve [Observable] object on which [Location] updates will be emitted
     *
     * @return [Observable] on which [Location] updates will be emitted
     */
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun getLocationObservable(): Observable<Location> {
        return locationObservable.doOnDispose {
            provider.removeLocationUpdates(locationCallback)
        }.doOnSubscribe {
            provider.requestLocationUpdates(locationRequest, locationCallback, null)
        }
    }
}