package com.binwin.easyfood.ui.meals.recipeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binwin.easyfood.model.MealsRepository
import com.binwin.easyfood.model.response.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeScreenViewModel(
    private val recipe : String,
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {

     var recipeState : MutableState<List<Recipe>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipe = getRecipe(recipe)
            recipeState.value = recipe
        }
    }


    private suspend fun getRecipe(recipeName : String) : List<Recipe>{
        return repository.getRecipe(recipeName).meals
    }
}