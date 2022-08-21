package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel

sealed class AddClothesEvent {
    data class OnClothesCategorySelected(val clothesCategoryModel: ClothesCategoryModel): AddClothesEvent()
    object OnClothesSaved: AddClothesEvent()
    object OnOpenClothesCategorySelector: AddClothesEvent()
    data class OnNameChanged(val name: String): AddClothesEvent()
    data class OnIdChanged(val friendlyId: String): AddClothesEvent()
    data class OnDateChanged(val date: String): AddClothesEvent()
    data class OnPurchasePriceChanged(val price: String): AddClothesEvent()
}