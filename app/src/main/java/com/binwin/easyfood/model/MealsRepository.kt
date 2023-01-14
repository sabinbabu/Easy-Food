package com.binwin.easyfood.model

import com.binwin.easyfood.model.api.MealsService
import com.binwin.easyfood.model.response.MealSingleCategoryResponse
import com.binwin.easyfood.model.response.MealsCategoryResponse
import com.binwin.easyfood.model.response.RecipeResponse

class MealsRepository(private val webService: MealsService = MealsService()) {
    suspend fun getMeals(): MealsCategoryResponse {
        //call api through service
        return webService.getMeals()
    }

    suspend fun getSingleCategoryMeals(categoryName: String): MealSingleCategoryResponse {
        return webService.getCategoryMeals(categoryName)
    }

    suspend fun getRecipe(recipeName : String) : RecipeResponse{
        return webService.getRecipe(recipeName)
    }
}