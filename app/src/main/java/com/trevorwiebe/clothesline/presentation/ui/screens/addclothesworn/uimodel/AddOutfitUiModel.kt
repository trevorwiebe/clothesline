package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel

data class AddOutfitUiModel (
    val clothesCategoryModel: ClothesCategoryModel,
    val isExpanded: Boolean = true,
    val clothesModelList: List<AddClothesUiModel>
)