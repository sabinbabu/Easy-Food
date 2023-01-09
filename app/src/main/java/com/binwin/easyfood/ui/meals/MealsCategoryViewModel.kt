package com.binwin.easyfood.ui.meals

import androidx.lifecycle.ViewModel
import com.binwin.easyfood.model.MealsRepository
import com.binwin.easyfood.model.response.MealResponse

class MealsCategoryViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {
    suspend fun getMeals() : List<MealResponse>{
        return repository.getMeals().categories
    }
}