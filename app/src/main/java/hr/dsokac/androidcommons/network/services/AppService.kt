package hr.dsokac.androidcommons.network.services

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
}