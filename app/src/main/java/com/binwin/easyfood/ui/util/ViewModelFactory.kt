package com.binwin.easyfood.ui.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.binwin.easyfood.ui.meals.recipeScreen.RecipeScreenViewModel
import com.binwin.easyfood.ui.meals.singleCategoryScreen.MealsSingleCategoryViewModel

class ViewModelFactory(private val fromCategory: String?, private val fromRecipe: String?) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (!fromCategory.isNullOrEmpty()) MealsSingleCategoryViewModel(fromCategory) as T
        else RecipeScreenViewModel(fromRecipe!!) as T
    }
}