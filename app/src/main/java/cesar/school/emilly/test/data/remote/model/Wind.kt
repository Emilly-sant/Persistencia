package cesar.school.emilly.test.data.remote.model

import com.google.gson.annotations.SerializedName

data class Wind(
        @SerializedName("speed")
        var speed: String
)