package com.binwin.easyfood.ui.meals.recipeScreen

import androidx.compose.animation.animateContentSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.binwin.easyfood.model.response.Recipe
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
            icon = Icons.Default.ArrowBack, title = mealName
        ) { navHostController!!.navigateUp() }
    }) {
        LazyColumn() {
            items(recipe) { recipe ->
                SingleRecipeScreen(recipe)
            }
        }
    }
}

@Composable
fun SingleRecipeScreen(recipe: Recipe) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.animateContentSize()
        ) {
            Surface(
                modifier = Modifier
                    .size(150.dp)
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
                modifier = Modifier.padding(5.dp)
            )

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = recipe.category,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(5.dp)
                )
            }
            Text(
                text = recipe.country,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(5.dp)
            )

            Text(
                text = recipe.instructions.replace(".","\n"),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(5.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SingleRecipeScreenPreview() {
    RecipeScreen(mealName = null, navHostController = null)
}
