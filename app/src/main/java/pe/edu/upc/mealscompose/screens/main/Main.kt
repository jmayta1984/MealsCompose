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

package pe.edu.upc.mealscompose.screens.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.mealscompose.Routes
import pe.edu.upc.mealscompose.screens.categories.Categories
import pe.edu.upc.mealscompose.screens.categories.CategoriesViewModel
import pe.edu.upc.mealscompose.screens.meals.Meals
import pe.edu.upc.mealscompose.screens.meals.MealsViewModel

@Composable
fun Main() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Categories.route
    ) {
        composable(Routes.Categories.route) {
            val categoryViewModel: CategoriesViewModel = hiltViewModel()
            categoryViewModel.fetchCategories()
            Categories(
                categoryViewModel
            ) {
                navController.navigate("${Routes.Meals.route}/$it")
            }
        }

        composable(
            Routes.Meals.routeWithArgument,
            arguments = listOf(navArgument(Routes.Meals.argument) { type = NavType.StringType })
        ) { backStackEntry ->
            val mealsViewModel: MealsViewModel = hiltViewModel()

            val name = backStackEntry.arguments!!.getString(
                Routes.Meals.argument, ""
            )
            mealsViewModel.fetchMealsByCategory(name)
            Meals(
                mealsViewModel
            )
        }
    }
}