package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel

sealed class ManageClothesEvent{
    data class OnClothesCategorySelected(val clothesCategoryModel: ClothesCategoryModel): ManageClothesEvent()
}

