package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

sealed class ViewClothesWornEvent{
    object OnNextDayClick: ViewClothesWornEvent()
    object OnPreviousDayClick: ViewClothesWornEvent()
}
