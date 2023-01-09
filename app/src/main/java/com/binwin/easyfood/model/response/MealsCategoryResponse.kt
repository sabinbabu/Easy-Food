package com.binwin.easyfood.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse (
    val categories : List<MealResponse>
)

data class MealResponse(
    @SerializedName("idCategory")
    val id: Int,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val image: String,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String
)