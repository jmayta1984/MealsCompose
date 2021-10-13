/*
 * Designed and developed by 2021 jmayta1984 (Jorge Mayta)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

        val response = mealService.fetchMealsByCategory(name)
        if (response.isSuccessful && response.body() != null) {
            for (item in response.body()!!.meals) {
                item.favorite = mealDao.fetchById(item.id) != null

                val meal = mealService.fetchMealsById(item.id).body()!!.meals[0]
                item.instructions = meal.instructions
                item.category = meal.category
                item.country = meal.country
            }
            return response.body()!!.meals
        }
        return listOf()
    }

    suspend fun insert(vararg meal: Meal) = mealDao.insert(*meal)

    suspend fun delete(vararg meal: Meal) = mealDao.delete(*meal)
}