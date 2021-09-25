package pe.edu.upc.mealscompose.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {

    @GET("filter.php")
    suspend fun fetchMealsByCategory(@Query("c") category: String): Response<MealResponse>
}