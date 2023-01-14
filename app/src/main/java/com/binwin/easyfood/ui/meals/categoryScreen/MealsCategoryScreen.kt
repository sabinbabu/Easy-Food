package com.binwin.easyfood.ui.meals.categoryScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.binwin.easyfood.ui.util.AppBar

@Composable
fun MealsCategoryScreen(navHostController: NavHostController?) {
    val viewModel: MealsCategoryViewModel = viewModel()
    val meals = viewModel.mealsState.value
    //lets things inside launched effect called only once

    Scaffold(topBar = { AppBar(icon = null, title = EASY_FOOD) {} }) {
        LazyColumn {
            items(meals) { meal ->
                MealCategory(meal) {
                    navHostController!!.navigate(MEALS_SINGLE_CATEGORY + meal.name)
                }
            }
        }
    }
}

@Composable
fun MealCategory(meal: MealResponse, clickAction: () -> Unit) {
    var isExpandable by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            .clickable(onClick = clickAction)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.animateContentSize()
        ) {
            Surface(
                modifier = androidx.compose.ui.Modifier
                    .padding(5.dp)
                    .size(88.dp)
            ) {
                AsyncImage(
                    model = meal.image,
                    contentDescription = null,
                    modifier = Modifier.clip(androidx.compose.foundation.shape.CircleShape)
                )
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = meal.description,
                        maxLines = if (!isExpandable) 2 else 10,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Icon(
                imageVector = if (!isExpandable) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                contentDescription = "minimize content",
                modifier = Modifier.clickable {
                    isExpandable = !isExpandable
                }
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun MealsCategoryPreview() {
    MealsCategoryScreen(null)
}