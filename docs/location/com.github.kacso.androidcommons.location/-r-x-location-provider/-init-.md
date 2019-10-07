[location](../../index.md) / [com.github.kacso.androidcommons.location](../index.md) / [RXLocationProvider](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`RXLocationProvider(context: Context, locationRequest: LocationRequest = LocationRequest.create())`

Use this class to retrieve real-time location updates.
Location updates are emitted through [Observable](#).
This class makes sure that location updates are stopped once source is disposed.

### Parameters

`context` - App active context

`locationRequest` - A data object that contains quality of service parameters for location updates.