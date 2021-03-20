package cesar.school.emilly.test.util

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityModel(
val id: Long,
val name: String,
val country: String,
val temp: String,
val tempIcon: String,
): Parcelable


