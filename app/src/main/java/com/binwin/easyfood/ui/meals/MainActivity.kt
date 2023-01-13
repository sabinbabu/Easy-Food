package com.binwin.easyfood.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.binwin.easyfood.ui.theme.EasyFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyFoodTheme {
                EasyFoodNavigator()
            }
        }
    }
}
