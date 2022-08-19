package com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel

sealed class AddClothesTypeEvent{
    data class OnClothesTypeAdded(val name: String): AddClothesTypeEvent()
    data class OnClothesTypeChange(val name: String): AddClothesTypeEvent()
    data class OnClothesTypeDelete(val clothesTypeModel: ClothesTypeModel): AddClothesTypeEvent()
}
