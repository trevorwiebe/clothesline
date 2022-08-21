package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import com.trevorwiebe.clothesline.domain.model.ClothesModel

sealed class AddClothesEvent {
    data class OnClothesCategorySelected(val clothesModel: ClothesModel): AddClothesEvent()
    data class OnClothesSaved(val clothesModel: ClothesModel): AddClothesEvent()
}