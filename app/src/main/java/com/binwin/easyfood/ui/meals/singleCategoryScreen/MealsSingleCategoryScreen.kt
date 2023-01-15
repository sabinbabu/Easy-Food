package com.binwin.easyfood.ui.meals.singleCategoryScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.binwin.easyfood.model.response.MealsSingleResponse
import com.binwin.easyfood.ui.meals.categoryScreen.MealCategory
import com.binwin.easyfood.ui.theme.*
import com.binwin.easyfood.ui.util.AppBar

@Composable
fun MealsSingleCategoryScreen(
    categoryName: String?, navHostController: NavHostController?
) {
    val viewModel: MealsSingleCategoryViewModel = viewModel()
    val meals = viewModel.mealsState.value

    viewModel.setString(categoryName!!)

    Scaffold(topBar = {
        AppBar(
            icon = Icons.Default.ArrowBack,
            title = categoryName
        ) { navHostController?.navigateUp() }
    }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {
            Column(modifier = Modifier.background(Background)) {
                Text(
                    text = "Meals",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(15.dp),
                    color = TitleColour,
                    style = MaterialTheme.typography.h5
                )
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(meals.size) { it ->
                        MealsScreen(meals[it]) {
                            navHostController!!.navigate(RECIPE_LIST + meals[it].description)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MealsScreen(meal: MealsSingleResponse, clickAction: () -> Unit) {
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
                text = meal.description,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(15.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Surface(
                modifier = androidx.compose.ui.Modifier
                    .padding(5.dp)
                    .size(250.dp),
                shape = CircleShape
            ) {
                AsyncImage(
                    model = meal.image,
                    contentDescription = null
                )
            }
        }
    }
}


@Composable
fun MealsSingleCategoryPreview() {
    MealsSingleCategoryScreen(null, null)
}
