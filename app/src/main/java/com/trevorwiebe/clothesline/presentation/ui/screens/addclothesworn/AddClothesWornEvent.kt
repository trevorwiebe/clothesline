package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel.AddOutfitUiModel

sealed class AddClothesWornEvent {
    data class OnOpenClothesCategory(val addOutfitUiModel: AddOutfitUiModel): AddClothesWornEvent()
}