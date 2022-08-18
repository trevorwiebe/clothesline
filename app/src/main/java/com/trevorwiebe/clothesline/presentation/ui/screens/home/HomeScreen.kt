package com.trevorwiebe.clothesline.presentation.ui.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trevorwiebe.clothesline.presentation.navigation.graphs.util.HomeNavGraph
import com.trevorwiebe.clothesline.presentation.ui.components.BottomBar

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold (
        bottomBar = { BottomBar(navController = navController)}
    ){
        HomeNavGraph(navController = navController)
    }

}