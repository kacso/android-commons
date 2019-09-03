package com.github.kacso.androidcommons.security.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Data model of login response defined by oAuth2 standard
 *
 * @author Danijel Sokač
 */
data class OAuth2LoginResponse(
    @Expose
    @SerializedName("access_token")
    val accessToken: String?,
    @Expose
    @SerializedName("refresh_token")
    val refreshToken: String?,
    @Expose
    @SerializedName("token_type")
    val tokenType: String?,
    @Expose
    @SerializedName("expires_in")
    val expiresIn: Long?
)