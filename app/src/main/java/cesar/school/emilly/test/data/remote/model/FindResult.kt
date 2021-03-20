package cesar.school.emilly.test.data.remote.model

import com.google.gson.annotations.SerializedName

data class FindResult(
    @SerializedName("cod")
    var cod: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("list")
    var cities: List<City>
)
