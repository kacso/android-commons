package com.github.kacso.androidcommons.security

/**
 * @author Danijel Sokač
 */

//Network
/**
 * String constant representing authorization header
 */
const val AUTHORIZATION_HEADER = "Authorization"


//Shared prefs
/**
 * Key for default shared preferences. It is primarily used to hold authorization information
 * such as username and tokens
 *
 */
const val SECURITY_PREFS = "security"

/**
 * Key used to store username of active user
 */
const val USERNAME_PREFS_KEY = "username"

/**
 * Key used to store access token for active session
 */
const val ACCESS_TOKEN_PREFS_KEY = "accessToken"

/**
 * Key used to store refresh token for active session
 */
const val REFRESH_TOKEN_PREFS_KEY = "refreshToken"

/**
 * Key used to store token type of access token
 */
const val TOKEN_TYPE_PREFS_KEY = "tokenType"

/**
 * Maximum time, in seconds, for obtaining connection during network call
 */
const val CONNECT_TIMEOUT_SECS = 10L

/**
 * Maximum wait time, in seconds, for receiving server response
 */
const val READ_TIMEOUT_SECS = 30L