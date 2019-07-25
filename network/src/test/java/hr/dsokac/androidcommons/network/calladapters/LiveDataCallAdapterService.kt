package hr.dsokac.androidcommons.network.calladapters

import androidx.lifecycle.LiveData
import hr.dsokac.androidcommons.network.models.ApiResponse
import hr.dsokac.androidcommons.test.models.Foo
import retrofit2.http.GET

interface LiveDataCallAdapterService {
    @GET("getData")
    fun getData(): LiveData<ApiResponse<Foo>>
}