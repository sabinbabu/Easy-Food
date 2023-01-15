package com.binwin.easyfood.ui.meals.categoryScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.binwin.easyfood.model.response.MealResponse
import com.binwin.easyfood.ui.theme.Background
import com.binwin.easyfood.ui.theme.EASY_FOOD
import com.binwin.easyfood.ui.theme.MEALS_SINGLE_CATEGORY
import com.binwin.easyfood.ui.theme.TitleColour
import com.binwin.easyfood.ui.util.AppBar

@Composable
fun MealsCategoryScreen(navHostController: NavHostController?) {
    val viewModel: MealsCategoryViewModel = viewModel()
    val meals = viewModel.mealsState.value
    //lets things inside launched effect called only once

    Scaffold(topBar = { AppBar(icon = null, title = EASY_FOOD) {} }) {

        Column(modifier = Modifier.background(Background)) {
            Text(
                text = "Meal Category",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(15.dp),
                color = TitleColour,
                style = MaterialTheme.typography.h5
            )
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(meals.size) { meal ->
                    MealCategory(meals[meal]) {
                        navHostController!!.navigate(MEALS_SINGLE_CATEGORY + meals[meal].name)
                    }
                }
            }
        }
    }
}

@Composable
fun MealCategory(meal: MealResponse, clickAction: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .height(250.dp)
            .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            .clickable(onClick = clickAction)

    ) {
        Column(
        ) {
            Text(
                text = meal.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(15.dp)
            )
            Surface(
                modifier = androidx.compose.ui.Modifier
                    .padding(5.dp)
                    .size(250.dp)
            ) {
                AsyncImage(
                    model = meal.image,
                    contentDescription = null,
                    modifier = Modifier.clip(androidx.compose.foundation.shape.CircleShape)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MealsCategoryPreview() {
    MealsCategoryScreen(null)
}