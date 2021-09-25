package pe.edu.upc.mealscompose.data.repository

import pe.edu.upc.mealscompose.data.remote.CategoryService
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val categoryService: CategoryService
) {
    suspend fun fetchCategories() = categoryService.fetchCategories()
}