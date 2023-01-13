package com.binwin.easyfood.ui.meals

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.binwin.easyfood.ui.util.AppBar

@Composable
fun RecipeScreen(mealName: String, navHostController: NavHostController) {

    Scaffold(topBar = {
        AppBar(
            icon = Icons.Default.ArrowBack,
            title = mealName
        ) { navHostController.navigateUp() }
    }) {
        Text(text = "This is Recipe Screen for $mealName")
    }

}