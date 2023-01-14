package com.binwin.easyfood.model.response

import com.google.gson.annotations.SerializedName

data class RecipeResponse (val meals : List<Recipe>)
data class Recipe(
    @SerializedName("idMeal")
    val id : Int,
    @SerializedName("strMeal")
    val name : String,
    @SerializedName("strCategory")
    val category : String,
    @SerializedName("strArea")
    val country : String,
    @SerializedName("strInstructions")
    val instructions : String,
    @SerializedName("strMealThumb")
    val image : String,
    @SerializedName("strSource")
    val source : String,
    @SerializedName("strYoutube")
    val video : String
)