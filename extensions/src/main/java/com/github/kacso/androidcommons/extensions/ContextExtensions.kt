package com.github.kacso.androidcommons.extensions

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.os.Build
import android.os.LocaleList
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import java.util.*

/**
 *
 * Extension class for Context class
 *
 * @author Danijel Sokač
 */

//Retrieve app data
/**
 * Get SDK independent color from resources
 *
 * @param color color resource ID
 * @return ARGB value of color
 */
fun Context.getSupportColor(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}

/**
 * Get color defined for active theme
 *
 * @param attr Theme attribute from which color should be read
 * @return ARGB value of color
 */
fun Context.getThemeColor(@AttrRes attr: Int): Int {
    val value = TypedValue()
    theme.resolveAttribute(attr, value, true)
    return value.data
}

/**
 * Get [Locale] currently used by app
 *
 * @return [Locale] currently used by app
 */
fun Context.getCurrentLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        resources.configuration.locales.get(0)
    } else {
        @Suppress("DEPRECATION")
        resources.configuration.locale
    }
}

/**
 * Get system default [Locale]
 *
 * @return System default [Locale]
 */
fun getSystemLocale(): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Resources.getSystem().configuration.locales.get(0)
    } else {
        @Suppress("DEPRECATION")
        Resources.getSystem().configuration.locale
    }
}

/**
 * Set locale to user defined locale (needed to support app language selection by user).
 * Make sure to use new [Context] in order to use new [Locale]
 *
 * @param newLocale [Locale] to be used as app [Locale]
 *
 * @return [Context] for which new [Locale] is set
 */
fun Context.toUserDefinedLocaleContext(newLocale: Locale): Context {
    val configuration = resources?.configuration ?: return this

    when {
        Build.VERSION.SDK_INT > Build.VERSION_CODES.N -> {
            configuration.setLocale(newLocale)
            LocaleList.setDefault(LocaleList(newLocale))

            return createConfigurationContext(configuration)
        }
        else -> {
            configuration.setLocale(newLocale)
            Locale.setDefault(newLocale)
            return createConfigurationContext(configuration)
        }
    }
}


//Start other apps

/**
 * Open default navigation app at location with coordinates ([latitude], [longitude])
 *
 * @param latitude latitude of target location
 * @param longitude longitude of target location
 */
@Throws(ActivityNotFoundException::class)
fun Context.openNavigation(latitude: Double, longitude: Double) {
    val gmmIntentUri = Uri.parse("google.navigation:q=$latitude,$longitude")
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    startActivity(mapIntent)
}

/**
 * Open Google Map app at location with coordinates ([latitude], [longitude])
 *
 * @param latitude latitude of target location
 * @param longitude longitude of target location
 */
@Throws(ActivityNotFoundException::class)
fun Context.openGoogleMapNavigation(latitude: Double, longitude: Double) {
    val gmmIntentUri = Uri.parse("google.navigation:q=$latitude,$longitude")
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    mapIntent.`package` = "com.google.android.apps.maps"
    startActivity(mapIntent)
}

/**
 * Starts voice call with default app.
 * [Manifest.permission.CALL_PHONE] permissions are required to complete action successfully.
 *
 * @param number Phone number to be called
 */
@RequiresPermission(allOf = [Manifest.permission.CALL_PHONE])
@Throws(SecurityException::class)
fun Context.performVoiceCall(number: String) {
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
    startActivity(intent)
}