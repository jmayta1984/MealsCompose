package pe.edu.upc.mealscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.upc.mealscompose.ui.theme.MealsComposeTheme
import pe.edu.upc.mealscompose.screens.main.Main

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MealsComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Main()
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsComposeTheme {
    }
}