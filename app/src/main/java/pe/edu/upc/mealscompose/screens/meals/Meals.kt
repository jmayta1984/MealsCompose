package pe.edu.upc.mealscompose.screens.meals

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import pe.edu.upc.mealscompose.data.model.Meal

@Composable
fun Meals(
    mealsViewModel: MealsViewModel
) {
    val meals: List<Meal> by mealsViewModel.meals.observeAsState(listOf())
    MealList(meals)
}

@Composable
fun MealList(meals: List<Meal>) {
    LazyColumn {
        items(meals) { meal ->
            MealRow(meal)
        }
    }
}

@Composable
fun MealRow(meal: Meal) {
    Text(meal.name)
}