package pe.edu.upc.mealscompose.data.repository

import pe.edu.upc.mealscompose.data.model.Category
import pe.edu.upc.mealscompose.data.remote.CategoryService
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val categoryService: CategoryService
) {
    suspend fun fetchCategories(): List<Category> {
        val response = categoryService.fetchCategories()
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!.categories
        }
        return listOf()
    }
}