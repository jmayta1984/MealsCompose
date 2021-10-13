package pe.edu.upc.mealscompose.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {

    @GET("categories.php")
    suspend fun fetchCategories(): Response<CategoryResponse>
}