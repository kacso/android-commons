package com.github.kacso.androidcommons.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiUser(
    @Expose
    @SerializedName("id")
    val id: String,
    @Expose
    @SerializedName("firstName")
    val firstName: String,
    @Expose
    @SerializedName("lastName")
    val lastName: String,
    @Expose
    @SerializedName("email")
    val email: String
) : Serializable