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

package pe.edu.upc.mealscompose.screens.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
    HorizontalPager(state = pagerState, count = meals.size) { page ->
        MealPage(
            meals[page],
            insertHero = { mealsViewModel.insert(meals[page]) },
            deleteHero = { mealsViewModel.delete(meals[page]) })
    }
}

@Composable
fun MealPage(meal: Meal, insertHero: () -> Unit, deleteHero: () -> Unit) {
    val favorite = remember {
        mutableStateOf(meal.favorite)
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        MealImage(meal)
        Spacer(modifier = Modifier.height(8.dp))
        MealHeader(meal)
        Spacer(modifier = Modifier.height(8.dp))
        IconButton(
            modifier = Modifier
                .size(32.dp),
            onClick = {
                if (favorite.value) {
                    deleteHero()
                } else {
                    insertHero()
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
        Spacer(modifier = Modifier.height(8.dp))
        MealCategory(meal)
        Spacer(modifier = Modifier.height(8.dp))
        MealCountry(meal)
        Spacer(modifier = Modifier.height(8.dp))
        MealInstructions(meal)
        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Composable
fun MealCountry(meal: Meal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        elevation = 2.dp
    ) {
        Column {
            Text(
                text = "Country",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meal.country,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MealCategory(meal: Meal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        elevation = 2.dp
    ) {
        Column {
            Text(
                text = "Category",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meal.category,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun MealImage(meal: Meal) {
    Image(
        painter = rememberImagePainter(meal.poster),
        contentDescription = null,
        modifier = Modifier
            .height(192.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MealHeader(meal: Meal) {
    Text(
        text = meal.name,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun MealInstructions(meal: Meal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        elevation = 2.dp
    ) {
        Column {
            Text(
                text = "Instructions",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meal.instructions,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}