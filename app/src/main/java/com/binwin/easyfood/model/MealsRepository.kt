package com.binwin.easyfood.model

import com.binwin.easyfood.model.api.MealsService
import com.binwin.easyfood.model.response.MealsCategoryResponse

class MealsRepository(private val webService: MealsService = MealsService()) {
    suspend fun getMeals(): MealsCategoryResponse {
        //call api through web service
        return webService.getMeals()
    }
}