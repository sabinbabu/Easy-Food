package com.binwin.easyfood.ui.meals

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeScreen(mealName : String){
    Text(text = "This is Recipe Screen for $mealName")
}