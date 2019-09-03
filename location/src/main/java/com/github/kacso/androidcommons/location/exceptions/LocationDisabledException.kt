package com.github.kacso.androidcommons.location.exceptions

/**
 * An Exception which is thrown when app does not have access to user location
 */
class LocationDisabledException : RuntimeException("Location service is disabled by user")