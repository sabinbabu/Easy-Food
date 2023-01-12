package com.binwin.easyfood.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.binwin.easyfood.model.response.MealsSingleResponse
import com.binwin.easyfood.ui.theme.RECIPE_LIST

@Composable
fun MealsSingleCategoryScreen(categoryName: String?, navHostController: NavHostController?) {
    val viewModel: MealsSingleCategoryViewModel = viewModel()
    val meals = viewModel.mealsState.value

    viewModel.setString(categoryName!!)
    LazyColumn {
        items(meals) { meal ->
            MealsScreen(meal){
                navHostController!!.navigate(RECIPE_LIST+meal.description)
            }
        }
    }
}

@Composable
fun MealsScreen(meal: MealsSingleResponse,clickAction: ()-> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            .clickable (onClick = clickAction)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.animateContentSize()
        ) {
            Surface(modifier = Modifier
                .size(88.dp)
                .padding(5.dp),
            shape = CircleShape) {
                AsyncImage(
                    model = meal.image,
                    contentDescription = null,
                    )
            }
            Text(
                text = meal.description,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(5.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MealsSingleCategoryPreview() {
    MealsSingleCategoryScreen(null, null)
}
