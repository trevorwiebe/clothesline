package com.trevorwiebe.clothesline.presentation.navigation.graphs.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.trevorwiebe.clothesline.presentation.navigation.BottomNavScreen
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.AddClothesWornScreen
import com.trevorwiebe.clothesline.presentation.ui.screens.profile.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graphs.HOME,
        startDestination = BottomNavScreen.ClothesWorn.route
    ){
        composable(route = BottomNavScreen.ClothesWorn.route){
        }
        composable(route = BottomNavScreen.AddClothesWorn.route){
            AddClothesWornScreen()
        }
        composable(route = BottomNavScreen.Profile.route){
            ProfileScreen()
        }
    }

}