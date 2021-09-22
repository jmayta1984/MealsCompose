package pe.edu.upc.mealscompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import pe.edu.upc.mealscompose.data.model.Category
import pe.edu.upc.mealscompose.data.remote.ApiClient
import pe.edu.upc.mealscompose.data.remote.ApiResponse
import pe.edu.upc.mealscompose.ui.theme.MealsComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private var categories by mutableStateOf(listOf<Category>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchCategories()
        setContent {
            MealsComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(categories)
                }
            }
        }
    }

    private fun fetchCategories() {
        val categoryService = ApiClient.build()
        val fetchCategories = categoryService.fetchCategories()

        fetchCategories.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                if (response.isSuccessful) {
                    categories = response.body()!!.categories
                } else {
                    Log.d("MainActivity", response.message())
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }

        })
    }
}

@Composable
fun MyApp(categories: List<Category>) {
    CategoryList(categories)
}

@Composable
fun CategoryList(categories: List<Category>) {
    LazyColumn {
        items(categories) { category ->
            CategoryRow(category)
        }
    }
}

@Composable
fun CategoryRow(category: Category) {
    Card {
        Column {
            CategoryImage(category)
            Text(category.name)
        }
    }
}

@Composable
fun CategoryImage(category: Category) {
    Image(
        painter = rememberImagePainter(category.poster),
        contentDescription = null,
        modifier = Modifier.size(128.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsComposeTheme {
    }
}