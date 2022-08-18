package com.trevorwiebe.clothesline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.trevorwiebe.clothesline.presentation.navigation.BottomNavScreen
import com.trevorwiebe.clothesline.presentation.ui.addclothestype.AddClothesTypeScreen
import com.trevorwiebe.clothesline.presentation.ui.theme.ClothesLineTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClothesLineTheme {

                val bottomNavItems = listOf(BottomNavScreen.ClothesWorn, BottomNavScreen.ClothesType)
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            bottomNavItems.forEach{ screen ->
                                BottomNavigationItem(
                                    icon = { Icon(Icons.Default.Add, contentDescription = null)},
                                    label = { Text(stringResource(id = screen.res)) },
                                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                    onClick = {
                                        navController.navigate(screen.route){
                                            popUpTo(navController.graph.findStartDestination().id){
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = BottomNavScreen.ClothesWorn.route, Modifier.padding(innerPadding)){
                        composable(BottomNavScreen.ClothesWorn.route) {}
                        composable(BottomNavScreen.ClothesType.route) {
                            AddClothesTypeScreen()
                        }
                    }
                }
            }
        }
    }
}