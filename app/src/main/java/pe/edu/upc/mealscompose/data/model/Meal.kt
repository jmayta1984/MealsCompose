package pe.edu.upc.mealscompose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "meals")
data class Meal(

    @SerializedName("idMeal")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @SerializedName("strMeal")
    @ColumnInfo(name = "meal_name")
    val name: String,

    @SerializedName("strMealThumb")
    @ColumnInfo(name = "meal_poster")
    val poster: String
) {
    @Ignore
    var favorite: Boolean = false
}