package com.trevorwiebe.clothesline.presentation.navigation

import androidx.annotation.StringRes
import com.trevorwiebe.clothesline.R

sealed class BottomNavScreen(
    val route: String,
    @StringRes val res: Int
){
    object ClothesType: BottomNavScreen(Route.ADD_CLOTHES_TYPE, R.string.clothes_type_screen)
    object ClothesWorn: BottomNavScreen(Route.VIEW_CLOTHES_WORN_TODAY, R.string.clothes_worn_screen)
}
