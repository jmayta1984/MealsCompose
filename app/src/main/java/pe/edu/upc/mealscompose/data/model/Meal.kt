package pe.edu.upc.mealscompose.data.model

import com.google.gson.annotations.SerializedName

class Meal(

    @SerializedName("idMeal")
    val id: String,

    @SerializedName("strMeal")
    val name: String,

    @SerializedName("strMealThumb")
    val poster: String
)