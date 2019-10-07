[location](../../index.md) / [com.github.kacso.androidcommons.location](../index.md) / [RXLocationProvider](./index.md)

# RXLocationProvider

`class RXLocationProvider`

Use this class to retrieve real-time location updates.
Location updates are emitted through [Observable](#).
This class makes sure that location updates are stopped once source is disposed.

### Parameters

`context` - App active context

`locationRequest` - A data object that contains quality of service parameters for location updates.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RXLocationProvider(context: Context, locationRequest: LocationRequest = LocationRequest.create())`<br>Use this class to retrieve real-time location updates. Location updates are emitted through [Observable](#). This class makes sure that location updates are stopped once source is disposed. |

### Functions

| Name | Summary |
|---|---|
| [getLocationObservable](get-location-observable.md) | `fun getLocationObservable(): Observable<Location>`<br>Retrieve [Observable](#) object on which [Location](#) updates will be emitted |
