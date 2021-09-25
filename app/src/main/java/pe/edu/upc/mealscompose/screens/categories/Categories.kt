package pe.edu.upc.mealscompose.screens.categories

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import pe.edu.upc.mealscompose.data.model.Category

@Composable
fun Categories(
    categoryViewModel: CategoriesViewModel,
    selectCategory: (name: String) -> Unit,
) {
    val categories: List<Category> by categoryViewModel.categories.observeAsState(listOf())
    CategoryList(categories, selectCategory)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryList(categories: List<Category>, selectCategory: (id: String) -> Unit) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(categories) { category ->
            CategoryRow(category, selectCategory)
        }
    }
}

@Composable
fun CategoryRow(category: Category, selectCategory: (name: String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp),
        elevation = 2.dp
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    selectCategory(category.name)
                }) {

            CategoryImage(category)
            Text(category.name)
        }


    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CategoryImage(category: Category) {
    Image(
        painter = rememberImagePainter(category.poster),
        contentDescription = null,
        modifier = Modifier.size(128.dp),

        )
}
