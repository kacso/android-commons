Android library which implements common functionalities in Android apps
=======================================================================
[![](https://jitpack.io/v/kacso/android-commons.svg)](https://jitpack.io/#kacso/android-commons)
       [![](https://jitci.com/gh/kacso/android-commons/svg)](https://jitci.com/gh/kacso/android-commons)

Configure your gradle as follows in order to use this lib:

**Step 1.** Add the JitPack repository to your build file
```groovy
    allProjects {
        repositories {
            maven {url 'https://jitpack.io'}
        }
    }
```

**Step 2.** Add the dependency
```groovy
    dependencies {
        implementation 'com.github.kacso:android-commons:{latest_version}'
    }
```

Lib is modularized in following modules which can be used independently:


# Common data
-   Module which contains common data objects.
-   Use `ErrorHolder` to notify UI of an error occurred on lower layers by providing error message to be displayed and/or exception which caused an error.
-   Use `Resource` sealed class to update UI with `Success`, `Loading` or `Error` statuses.
  
# Core
-   Stop writing boilerplate code in order to initialize your activity/fragment with your layout. 
-   Make permission check as simple as ever because `BaseActivity`/`BaseFragment`/`BaseDialog` implements permission manager from Permission module.
-   Default implementation of progress dialogs, displaying message and errors, handling Unauthorized access can speed up your development, especially for PoC.
-   Any class can be further customized in order to create your own user experience.
-   Using `NetworkBoundResource`, make caching of network request as simple as possible.

# Extensions
-   Benefit of numerous extension function build on top of standard Android classes.
-   Show fragment with animation by simply calling `attachFragment(R.id.fragmentHolder, MyFragment(), "TAG", FadeAnimation)`.
-   Initiate voice call by executing only `context.performVoiceCall("phone_number")`, or start Google Maps by providing only latitude and longitude: `context.openGoogleMapNavigation(45.81, 15.96)`.
-   Check if provided string is an email: `"mail@mail.com".isEmail()`, or find if query matches list of keywords: `listOf("KeyA", "KeyB").matches("A")`.
-   Display `LiveData<String>` in TextView programmatically: `textView.setLiveText(lifecycleOwner, liveData)`. 

# Location
-   Get access to user current location. In case that you need single update, just call `SingleShotLocationProvider.requestSingleUpdate(context)`.
-   For stream of location updates choose between LiveData or RXJava Observable.

# Logger
-  Simplify logging process by calling `exception.log()` or `log("SomeMessage")` in your code. There are two implementation of logger available (Logger which uses `android.util.Log` or `CrashlyticsLogger`), but you can always implement your own.

# Network
-  Module which defines standard HTTP responses exception in order to easily track server response. Provides default `NetworkExceptionFactory` which will convert HTTP response to this exception. Also, there is `LiveDataCallAdapter` which will enable you to return `LiveData` from your Retrofit service (required for `NetworkBoundResource`).

# Permissions
- By default, when you are requesting permissions, you need to listen `onRequestPermissionResult` and parse response to make decision on what to do next. With this lib you can define your callback while requesting permissions:
    ```kotlin
        permissionManager.requirePermissions(requestedPermissions, object : PermissionCallback {
            override fun onAllowed() {
                //User has allowed access
            }

            override fun onDisallowed() {
                //User has rejected access
            }
        })
     ```
- `BaseActiviy`, `BaseFragment` and `BaseDialog` from core module have built-in support for permission managers

# Preferences
- This module provides easier access to `SharedPreferences` for read and write actions
- By default, to write `Sting` value to preferences you would need to do following:
    ```kotlin
        val prefEditor = PreferenceManager.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE)
                            .edit()
        prefEditor.putString("MYSTRLABEL", "myStringToSave")
        prefEditor.apply()
    ```

    With `SharedPrefs` you can do following:
    ```kotlin
        val prefs = SharedPrefsFactory.getSharedPrefs(context, "PREFS_NAME")
        prefs.write("MYSTRLABEL", "myStringToSave")
    ```
- For more complex action, you can always access to `SharedPreferences` object used withing `SharedPrefs`

# Security
- Module which implements OAuth2 protocol defined by RFC 6749 for password grant type
- Module provides support for Coroutines and RXJava2
- To perform authorization on server use one of provided repositories (`OAuth2Repository`, `RxOAuth2Repository`). Those repositories will, on login, store access and refresh tokens to shared preferences which you can later retrieve.
- To authorize user during other requests, use `OAuth2Interceptor` or `RxOAuth2Repository` depending on which repository you decided to use

# Serialization
- This module provides Gson `TypeAdapters` for Threeten JavaTime
- To register this adapters to your Gson instance, you can use extension `GsonBuilder.registerJavaTimeTypeAdapters()`
- Use `RuntimeTypeAdapterFactory` when runtime type of an value differs from their declaration type

# Test
- **Use functionalities of this module only for testing**
- This module contains boilerplate code used during testing, eg:
    - `StaticMock` mock SDK version during test execution or mock any other static final field
    - `InstantTaskExecutorExtension` Junit5 extension used to test LiveData
    - `LiveDataExtensions` verify value in LiveData





To use only one of the modules you need to specify only desired modules in your gradle:
```groovy
    dependencies {
        implementation 'com.github.kacso.android-commons:{module_name}:{latest_version}'
    }
```
