package com.binwin.easyfood.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.binwin.easyfood.ui.theme.EasyFoodTheme
import com.binwin.easyfood.ui.theme.MEALS_CATEGORY
import com.binwin.easyfood.ui.theme.MEALS_SINGLE_CATEGORY
import com.binwin.easyfood.ui.theme.RECIPE_LIST

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyFoodTheme {
                EasyFood()
            }
        }
    }
}

@Composable
fun EasyFood() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MEALS_CATEGORY) {
        composable(MEALS_CATEGORY) {
            MealsCategoryScreen(navController)
        }

        composable(
            route = "$MEALS_SINGLE_CATEGORY{mealCategory}",
            arguments = listOf(navArgument("mealCategory") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            MealsSingleCategoryScreen(
                navBackStackEntry.arguments!!.getString("mealCategory"),
                navController
            )
        }

        composable(route="$RECIPE_LIST{mealName}", //use Id here
        arguments = listOf(navArgument("mealName"){
            type = NavType.StringType
        })
        ){navBackStackEntry ->
            RecipeScreen(
                navBackStackEntry.arguments!!.getString("mealName")!!
            )
        }
    }
}