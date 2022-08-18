package com.trevorwiebe.clothesline.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.trevorwiebe.clothesline.R

sealed class BottomNavScreen(
    val route: String,
    @StringRes val res: Int,
    @DrawableRes val icon: ImageVector
){
    object ClothesWorn: BottomNavScreen(Route.VIEW_CLOTHES_WORN_TODAY, R.string.clothes_worn_screen, Icons.Default.Home)
    object AddClothesWorn: BottomNavScreen(Route.ADD_CLOTHES_WORN, R.string.add_clothes_worn_screen, Icons.Default.Add)
    object Profile: BottomNavScreen(Route.PROFILE, R.string.profile, Icons.Default.Person)
}
