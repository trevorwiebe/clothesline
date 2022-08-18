package com.trevorwiebe.clothesline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.trevorwiebe.clothesline.presentation.navigation.graphs.util.HomeNavGraph
import com.trevorwiebe.clothesline.presentation.ui.screens.home.HomeScreen
import com.trevorwiebe.clothesline.presentation.ui.theme.ClothesLineTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClothesLineTheme {
                val navController = rememberNavController()
                HomeScreen(navController = navController)
            }
        }
    }
}