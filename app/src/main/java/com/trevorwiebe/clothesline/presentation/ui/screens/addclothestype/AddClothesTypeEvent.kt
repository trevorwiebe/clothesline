package com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype

sealed class AddClothesTypeEvent{
    data class OnClothesTypeAdded(val name: String): AddClothesTypeEvent()
    data class OnClothesTypeChange(val name: String): AddClothesTypeEvent()
}
