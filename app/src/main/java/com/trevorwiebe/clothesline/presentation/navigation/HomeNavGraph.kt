package com.trevorwiebe.clothesline.presentation.navigation.graphs.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.trevorwiebe.clothesline.presentation.navigation.BottomNavScreen
import com.trevorwiebe.clothesline.presentation.navigation.Route
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.AddClothesScreen
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothescategory.AddClothesTypeScreen
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.AddClothesWornScreen
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.ManageClothesScreen
import com.trevorwiebe.clothesline.presentation.ui.screens.profile.ProfileScreen
import com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn.ViewClothesWornScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreen.ClothesWorn.route
    ){
        composable(route = BottomNavScreen.ClothesWorn.route){
            ViewClothesWornScreen()
        }
        composable(route = BottomNavScreen.AddClothesWorn.route){
            AddClothesWornScreen()
        }
        composable(route = BottomNavScreen.Profile.route){
            ProfileScreen(navController)
        }
        composable(route = Route.MANAGE_CLOTHES){
            ManageClothesScreen(onNavigateToAddClothes = {clothesModelId ->
                navController.navigate(
                    Route.ADD_CLOTHES + "/$clothesModelId"
                )
            })
        }
        composable(route = Route.MANAGE_CLOTHES_TYPE){
            AddClothesTypeScreen()
        }
        composable(route = Route.SETTINGS){

        }
        composable(route = Route.ADD_CLOTHES + "/{clothesModelId}",
            arguments = listOf(
                navArgument("clothesModelId"){
                    type = NavType.IntType
                }
            )
        ){
            val clothesModelId = it.arguments?.getInt("clothesModelId")!!
            AddClothesScreen(
                clothesId = clothesModelId,
                onNavigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }

}