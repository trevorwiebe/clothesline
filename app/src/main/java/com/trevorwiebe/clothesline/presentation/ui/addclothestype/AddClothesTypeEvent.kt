package com.trevorwiebe.clothesline.presentation.ui.addclothestype

sealed class AddClothesTypeEvent{
    data class OnClothesTypeAdded(val name: String): AddClothesTypeEvent()
    data class OnClothesTypeChange(val name: String): AddClothesTypeEvent()
}
