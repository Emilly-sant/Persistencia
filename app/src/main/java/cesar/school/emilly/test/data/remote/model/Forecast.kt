package cesar.school.emilly.test.data.remote.model

import com.google.gson.annotations.SerializedName

data class Forecast(
        @SerializedName("id")
        var id: Long,

        @SerializedName("weather")
        var weathers: List<Weather>,

        @SerializedName("main")
        var temp: Temp,

        @SerializedName("clouds")
        var clouds: Clouds,

        @SerializedName("wind")
        var wind: Wind,

        @SerializedName("dt_text")
        var date: String,

        @SerializedName("main")
        var main: String
)