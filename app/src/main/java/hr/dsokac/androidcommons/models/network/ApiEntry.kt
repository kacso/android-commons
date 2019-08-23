package hr.dsokac.androidcommons.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.threeten.bp.Instant
import java.io.Serializable

data class ApiEntry(
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("date")
    val date: Instant,
    @Expose
    @SerializedName("value")
    val value: String
) : Serializable