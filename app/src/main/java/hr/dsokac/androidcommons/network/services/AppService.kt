package hr.dsokac.androidcommons.network.services

import androidx.lifecycle.LiveData
import hr.dsokac.androidcommons.models.network.ApiUser
import hr.dsokac.androidcommons.network.models.ApiResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET

interface AppService {

    @GET("/api/users?page=1")
    fun getSingle(): Single<ResponseBody>

    @GET("/api/users?page=1")
    suspend fun getSuspend(): ResponseBody

    @GET("/badApi/users?page=1")
    fun getBadSingle(): Single<ResponseBody>

    @GET("/badApi/users?page=1")
    suspend fun getBadSuspend(): ResponseBody

    @GET("users/active")
    fun getUserInfo(): LiveData<ApiResponse<ApiUser>>
}