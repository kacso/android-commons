# android-commons
Android library which implements common functionalities in Android apps

Lib is modulirazed in following modules which can be used independently:


Common data
  Module which contains common data objects. 
  Use ErrorHolder to notify UI of an error occurred on lower layers by providing error message to be displayed and/or exception which caued an error.
  Use Resource sealed class to update UI with Success, Loading or Error statuses.
  
Core
  Stop writing boilerplate code in order to initialize your activity/fragment with your layout. 
  Make permission check as simple as ever because BaseActivity/BaseFragment/BaseDialog implements permission manager from Permission module.
  Default implementation of progress dialogs, displaying message and errors, handling Unauthorized access can speed up your developlment, especially for PoC.
  Any class can be further customized in order to create your own user experience.
  Using NetworkBoundResource, make caching of network request as simple as possible.

Extensions
  Benefit of nomerous extension function build on top of standard Android classes.
  Show fragment with animation by simply calling attachFragment(R.id.fragmentHolder, MyFragment(), "TAG", FadeAnimation).
  Intiate voice call by executing only context.performVoiceCall("phone_number"), or start Google Maps by providing only latitude and longitude: context.openGoogleMapNavigation(45.81, 15.96).
  Check if provided string is an email: "mail@mail.com".isEmail(), or find if query matches list of keywords: listOf("KeyA", "KeyB").matches("A").
  Display LiveData<String> in TextView programmatically: textView.setLiveText(lifecycleOwner, liveData). 

Location
  Get access to user current location. In case that you need single update, just call SingleShotLocationProvider.requestSingleUpdate(context).
  For stream of location updates choose between LiveData or RXJava Observable.

Logger
  Simplify logging process by calling exception.log() or log("SomeMessage") in your code. There are two implementation of logger avaible (Logger which uses android.util.Log or CrashlyticsLogger), but you can always implement your own.

Network
  Module which defines standard HTTP responses exception in order to easly track server response. Provides default NetworkExceptionFactory which will convert HTTP response to this exception. Also, there is LiveDataCallAdapter which will enable you to return LiveData from your Retrofit service (required for NetworkBoundResource).

Permissions

Preferences

Security

Serialization

Test
