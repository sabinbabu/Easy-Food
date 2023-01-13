package com.binwin.easyfood.model.response

import com.google.gson.annotations.SerializedName

data class MealSingleCategoryResponse(
    val meals: List<MealsSingleResponse>
)

data class MealsSingleResponse(
    @SerializedName("strMeal")
    val description: String,
    @SerializedName("strMealThumb")
    val image: String,
    @SerializedName("idMeal")
    val id: Int
)