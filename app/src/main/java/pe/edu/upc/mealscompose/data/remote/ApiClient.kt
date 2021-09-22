package pe.edu.upc.mealscompose.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val API_BASE_URL = "https://www.themealdb.com/api/json/v2/9973533/"
    private var categoryService: CategoryService? = null

    fun build(): CategoryService {
        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder.build()

        categoryService = retrofit.create(CategoryService::class.java)

        return categoryService as CategoryService
    }
}