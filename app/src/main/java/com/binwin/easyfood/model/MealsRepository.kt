package com.binwin.easyfood.model

import com.binwin.easyfood.model.response.MealResponse
import com.binwin.easyfood.model.response.MealsCategoryResponse

class MealsRepository {
    fun getMeals(): MealsCategoryResponse{
        return MealsCategoryResponse(arrayListOf())  //call api
    }
}