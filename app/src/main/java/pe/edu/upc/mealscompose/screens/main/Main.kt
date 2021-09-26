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