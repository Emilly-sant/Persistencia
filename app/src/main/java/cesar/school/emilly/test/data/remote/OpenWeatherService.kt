package cesar.school.emilly.test.data.remote

import cesar.school.emilly.test.data.remote.model.FindResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {

    @GET("/data/2.5/find")
    fun findCity(
        @Query("q")
        cityName: String,

        @Query("units")
        units: String,

        @Query("lang")
        lang: String,

        @Query("appid")
        appId: String
    ): Call<FindResult>
}