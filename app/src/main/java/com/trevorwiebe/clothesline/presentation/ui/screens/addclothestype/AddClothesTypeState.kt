package com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel

data class AddClothesTypeState(
    val clothesTypeString: String = "",
    val clothesTypesList: List<ClothesTypeModel> = emptyList()
)
