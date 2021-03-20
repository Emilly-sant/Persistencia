package cesar.school.emilly.test.data.remote.model

import com.google.gson.annotations.SerializedName

data class City(
        @SerializedName("id")
        var id: Long,

        @SerializedName("name")
        var name: String,

        @SerializedName("sys")
        var country: Country,

        @SerializedName("weather")
        var weathers: List<Weather>,

        @SerializedName("main")
        var temp: Temp,

        @SerializedName("clouds")
        var clouds: Clouds,

        @SerializedName("wind")
        var wind: Wind
)