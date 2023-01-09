package com.binwin.easyfood.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.binwin.easyfood.ui.theme.EasyFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyFoodTheme {
                MealsCategoryScreen()
            }
        }
    }
}


@Composable
fun MealsCategoryScreen() {
   val viewModel : MealsCategoryViewModel = viewModel()
   val meals = viewModel.getMeals()
   Text(text = "Hello Food")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsCategoryScreen()
}