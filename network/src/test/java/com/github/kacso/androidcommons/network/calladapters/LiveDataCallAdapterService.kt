package com.github.kacso.androidcommons.network.calladapters

import androidx.lifecycle.LiveData
import com.github.kacso.androidcommons.network.models.ApiResponse
import com.github.kacso.androidcommons.test.models.Foo
import retrofit2.http.GET

interface LiveDataCallAdapterService {
    @GET("getData")
    fun getData(): LiveData<ApiResponse<Foo>>
}