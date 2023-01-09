package com.binwin.easyfood.ui.meals

import androidx.lifecycle.ViewModel
import com.binwin.easyfood.model.MealsRepository

class MealsCategoryViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {
}