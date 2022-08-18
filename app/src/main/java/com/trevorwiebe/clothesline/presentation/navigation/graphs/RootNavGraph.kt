package com.trevorwiebe.clothesline.presentation.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.trevorwiebe.clothesline.presentation.navigation.graphs.util.Graphs
import com.trevorwiebe.clothesline.presentation.ui.screens.home.HomeScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.ROOT,
        startDestination = Graphs.HOME
    ){
        composable(route = Graphs.HOME){
            HomeScreen()
        }
    }
}