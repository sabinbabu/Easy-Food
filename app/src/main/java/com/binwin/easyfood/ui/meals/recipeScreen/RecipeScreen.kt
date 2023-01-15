package com.binwin.easyfood.ui.meals.recipeScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.binwin.easyfood.model.response.Recipe
import com.binwin.easyfood.ui.theme.Background
import com.binwin.easyfood.ui.theme.TitleColour
import com.binwin.easyfood.ui.util.AppBar

@Composable
fun RecipeScreen(
    mealName: String?,
    navHostController: NavHostController?,
    viewModel: RecipeScreenViewModel = viewModel()
) {

    val recipe = viewModel.recipeState.value
    viewModel.setString(mealName!!)

    Scaffold(topBar = {
        AppBar(
            icon = Icons.Default.ArrowBack,
            title = null
        ) { navHostController!!.navigateUp() }
    }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {
            LazyColumn() {
                items(recipe) { recipe ->
                    SingleRecipeScreen(recipe)
                }
            }
        }
    }
}

@Composable
fun SingleRecipeScreen(recipe: Recipe) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.animateContentSize()
        ) {
            Surface(
                modifier = Modifier
                    .size(250.dp)
                    .padding(5.dp),
                shape = CircleShape
            ) {
                AsyncImage(
                    model = recipe.image,
                    contentDescription = null,
                )
            }
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(5.dp),
                color = TitleColour
            )
                Text(
                    text = recipe.category,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(5.dp),
                    color = TitleColour
                )
            Text(
                text = recipe.country,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(5.dp),
                color = Color.Black
            )

            Surface(
                color = Color.White,
                modifier = Modifier.padding(15.dp),
                shape = RoundedCornerShape(5,5,5,5)
            ) {
                Text(
                    text = recipe.instructions.replace(".", "\n"),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(20.dp),
                    color = Color.Black
                )
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun SingleRecipeScreenPreview() {
    RecipeScreen(mealName = null, navHostController = null)
}
