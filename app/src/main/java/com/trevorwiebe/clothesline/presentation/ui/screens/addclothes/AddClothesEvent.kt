package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel

sealed class AddClothesEvent {
    data class OnClothesCategorySelected(val clothesCategoryModel: ClothesCategoryModel): AddClothesEvent()
    data class OnClothesSaved(val clothesModel: ClothesModel): AddClothesEvent()
    object OnOpenClothesCategorySelector: AddClothesEvent()
}