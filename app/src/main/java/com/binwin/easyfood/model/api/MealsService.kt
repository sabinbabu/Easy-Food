package com.binwin.easyfood.model.api

import com.binwin.easyfood.model.response.MealSingleCategoryResponse
import com.binwin.easyfood.model.response.MealsCategoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class MealsService {
    //retrofit implementation
    var api : MealsApi

    init{   //initializing Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")//base URL
            .addConverterFactory(GsonConverterFactory.create()) //converts json to Gson
            .build()

        api = retrofit.create(MealsApi::class.java) // passing interface to retrofit; // so that actual request can be done ; we want to get meals

    }


    suspend fun getMeals(): MealsCategoryResponse { //returns MealsCategory, call is for async
        return api.getMeals()
    }

    suspend fun getCategoryMeals(categoryName:String) : MealSingleCategoryResponse{
        return api.getCategoryMeals(categoryName)
    }

    //retrofit implementation
    interface MealsApi{
        @GET("categories.php")
        suspend fun getMeals(): MealsCategoryResponse //meal end point to get meal
        @GET("filter.php")
        suspend fun getCategoryMeals(@Query("c") categoryName : String) : MealSingleCategoryResponse
    }
}