package pe.edu.upc.mealscompose.screens.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import pe.edu.upc.mealscompose.data.model.Meal

@Composable
fun Meals(
    mealsViewModel: MealsViewModel
) {
    val meals: List<Meal> by mealsViewModel.meals.observeAsState(listOf())
    MealList(meals, mealsViewModel)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MealList(meals: List<Meal>, mealsViewModel: MealsViewModel) {

    val pagerState = rememberPagerState(meals.size)

    HorizontalPager(state = pagerState) { page ->
        MealPage(meals[page], mealsViewModel)
    }

}

@Composable
fun MealPage(meal: Meal, mealsViewModel: MealsViewModel) {
    val favorite = remember {
        mutableStateOf(meal.favorite)
    }

    Column(
        Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                MealImage(meal)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    meal.name, textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    modifier = Modifier
                        .size(32.dp),
                    onClick = {
                        if (favorite.value) {
                            mealsViewModel.delete(meal)
                        } else {
                            mealsViewModel.insert(meal)
                        }
                        favorite.value = !favorite.value
                    }) {
                    Icon(
                        Icons.Filled.Favorite,
                        null,
                        tint = if (favorite.value)
                            MaterialTheme.colors.primary
                        else
                            MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealImage(meal: Meal) {
    Image(
        painter = rememberImagePainter(meal.poster),
        contentDescription = null
    )
}