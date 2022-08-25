package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.uimodel

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel

data class ClothesUiModel (
    val clothesCategoryModel: ClothesCategoryModel,
    val isExpanded: Boolean = true,
    val clothesModelList: List<ClothesModel>
)