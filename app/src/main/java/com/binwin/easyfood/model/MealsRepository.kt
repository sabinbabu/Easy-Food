package com.binwin.easyfood.model

import com.binwin.easyfood.model.api.MealsService
import com.binwin.easyfood.model.response.MealSingleCategoryResponse
import com.binwin.easyfood.model.response.MealsCategoryResponse

class MealsRepository(private val webService: MealsService = MealsService()) {
    suspend fun getMeals(): MealsCategoryResponse {
        //call api through web service
        return webService.getMeals()
    }

    suspend fun getSingleCategoryMeals(categoryName : String) : MealSingleCategoryResponse{
        return webService.getCategoryMeals(categoryName)
    }
}