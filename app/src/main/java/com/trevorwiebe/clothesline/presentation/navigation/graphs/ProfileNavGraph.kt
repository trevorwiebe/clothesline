package com.trevorwiebe.clothesline.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype.AddClothesTypeScreen

@Composable
fun ProfileNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        route = Route.PROFILE,
        startDestination = BottomNavScreen.Profile.route
    ){
        composable(BottomNavScreen.ClothesWorn.route) {}
        composable(BottomNavScreen.AddClothesWorn.route){}
        profileNavGraph(navController)
    }
}

fun NavGraphBuilder.profileNavGraph(navController: NavController){
    navigation(
        route = Route.PROFILE,
        startDestination = Route.PROFILE
    ){
        composable(route = Route.ADD_CLOTHES){

        }
        composable(route = Route.ADD_CLOTHES_TYPE){
            AddClothesTypeScreen()
        }
        composable(route = Route.SETTINGS){

        }
    }
}