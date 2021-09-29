package pe.edu.upc.mealscompose.repository

import pe.edu.upc.mealscompose.data.local.MealDao
import pe.edu.upc.mealscompose.data.model.Meal
import pe.edu.upc.mealscompose.data.remote.MealService
import javax.inject.Inject

class MealRepository @Inject constructor(
    private val mealService: MealService,
    private val mealDao: MealDao
) {

    suspend fun fetchMealsByCategory(name: String): List<Meal> {

        val fetchMealsByCategory = mealService.fetchMealsByCategory(name)
        val response = mealService.fetchMealsByCategory(name)
        if (response.isSuccessful && response.body() != null) {
            for (item in response.body()!!.meals) {
                item.favorite = mealDao.fetchById(item.id) != null
            }
            return response.body()!!.meals
        }
        return listOf()
    }

    suspend fun insert(vararg meal: Meal) = mealDao.insert(*meal)

    suspend fun delete(vararg meal: Meal) = mealDao.delete(*meal)
}