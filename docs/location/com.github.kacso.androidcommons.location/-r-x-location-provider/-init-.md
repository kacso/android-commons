[location](../../index.md) / [com.github.kacso.androidcommons.location](../index.md) / [RXLocationProvider](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`RXLocationProvider(context: <ERROR CLASS>, locationRequest: <ERROR CLASS> = LocationRequest.create())`

Use this class to retrieve real-time location updates.
Location updates are emitted through [Observable](#).
This class makes sure that location updates are stopped once source is disposed.

### Parameters

`context` - App active context

`locationRequest` - A data object that contains quality of service parameters for location updates.