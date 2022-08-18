package com.trevorwiebe.clothesline.presentation.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.trevorwiebe.clothesline.presentation.navigation.BottomNavScreen

@Composable
fun BottomBar(
    navController: NavController
) {

    val bottomNavItems = listOf(BottomNavScreen.ClothesWorn, BottomNavScreen.AddClothesWorn, BottomNavScreen.Profile)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = bottomNavItems.any{it.route == currentDestination?.route}
    if(bottomBarDestination){
        BottomNavigation {
            bottomNavItems.forEach{ screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavScreen,
    currentDestination: NavDestination?,
    navController: NavController
){
    BottomNavigationItem(
        icon = { Icon(screen.icon, contentDescription = null) },
        selectedContentColor = MaterialTheme.colors.secondary,
        unselectedContentColor = MaterialTheme.colors.onBackground,
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