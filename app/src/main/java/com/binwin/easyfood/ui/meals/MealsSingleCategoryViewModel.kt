package com.binwin.easyfood.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binwin.easyfood.model.MealsRepository
import com.binwin.easyfood.model.response.MealResponse
import com.binwin.easyfood.model.response.MealsSingleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsSingleCategoryViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {
    val mealsState: MutableState<List<MealsSingleResponse>> = mutableStateOf(emptyList())
    private lateinit var categoryName: String

    fun setString(name: String) {
        categoryName = name
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getSingleCategoryMeals(categoryName)
            mealsState.value = meals
        }
    }


    private suspend fun getSingleCategoryMeals(categoryName: String): List<MealsSingleResponse> {
        return repository.getSingleCategoryMeals(categoryName).meals
    }
}