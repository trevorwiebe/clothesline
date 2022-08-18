package com.trevorwiebe.clothesline.presentation.ui.viewclothesworn

sealed class ViewClothesWornEvent{
    object OnNextDayClick: ViewClothesWornEvent()
    object OnPreviousDayClick: ViewClothesWornEvent()
}
