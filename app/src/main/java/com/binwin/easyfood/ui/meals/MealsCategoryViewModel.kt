package com.binwin.easyfood.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.binwin.easyfood.model.MealsRepository
import com.binwin.easyfood.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoryViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    //creating custom scope instead of viewModel Scope
    private val mealsJob = Job()

    init {
        val scope = CoroutineScope(mealsJob+Dispatchers.IO)
        scope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState : MutableState<List<MealResponse>> =  mutableStateOf(emptyList())

    override fun onCleared() { //triggered when view model is destroyed
        super.onCleared()
        mealsJob.cancel()
    }

    private suspend fun getMeals() : List<MealResponse>{
        return repository.getMeals().categories
    }
}