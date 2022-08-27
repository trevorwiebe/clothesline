package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel

import com.trevorwiebe.clothesline.domain.model.ClothesModel

data class AddClothesUiModel(
    val clothesModel: ClothesModel,
    val isChecked: Boolean = true
)