package com.binwin.easyfood.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.binwin.easyfood.model.response.MealResponse
import com.binwin.easyfood.ui.theme.EasyFoodTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    val meals = viewModel.mealsState.value
    //lets things inside launched effect called only once
    LazyColumn {
        items(meals){meal ->
            Text(text = meal.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsCategoryScreen()
}