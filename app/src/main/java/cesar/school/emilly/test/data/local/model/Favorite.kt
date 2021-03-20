package cesar.school.emilly.test.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 1) define uma tabela
@Entity(tableName = "tb_favorites")
data class Favorite(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long,

    @ColumnInfo(name = "cityName")
    var cityName: String,

    @ColumnInfo(name = "city_country")
    var cityCountry: String

)