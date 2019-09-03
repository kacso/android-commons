[location](../index.md) / [com.github.kacso.androidcommons.location](.)

## Package com.github.kacso.androidcommons.location

### Types

| Name | Summary |
|---|---|
| [LocationProvider](-location-provider/index.md) | `class LocationProvider`<br>Use this class to retrieve real-time location updates.
Location updates are emitted through [LiveData](#) inside [Resource](#) model.
This class makes sure that location updates are generated only when there are active observers. |
| [RXLocationProvider](-r-x-location-provider/index.md) | `class RXLocationProvider`<br>Use this class to retrieve real-time location updates.
Location updates are emitted through [Observable](#).
This class makes sure that location updates are stopped once source is disposed. |
| [SingleShotLocationProvider](-single-shot-location-provider/index.md) | `object SingleShotLocationProvider`<br>Class which is used to retrieve current user location with one request. |
