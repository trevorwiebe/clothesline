package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel

data class ManageClothesState(
    val selectedClothesCategory: ClothesCategoryModel = ClothesCategoryModel(0, "No Clothes Categories"),
    val clothesCategoryList: List<ClothesCategoryModel> = emptyList(),
    val clothesList: List<ClothesModel> = emptyList()
)

