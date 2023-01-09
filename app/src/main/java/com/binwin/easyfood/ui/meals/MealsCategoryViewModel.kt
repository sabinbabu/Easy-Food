package com.binwin.easyfood.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binwin.easyfood.model.MealsRepository
import com.binwin.easyfood.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoryViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState : MutableState<List<MealResponse>> =  mutableStateOf(emptyList())

    private suspend fun getMeals() : List<MealResponse>{
        return repository.getMeals().categories
    }
}