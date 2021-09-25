package pe.edu.upc.mealscompose.data.repository

import pe.edu.upc.mealscompose.data.remote.MealService
import javax.inject.Inject

class MealRepository @Inject constructor(private val mealService: MealService) {

    suspend fun fetchMealsByCategory(name: String) = mealService.fetchMealsByCategory(name)
}