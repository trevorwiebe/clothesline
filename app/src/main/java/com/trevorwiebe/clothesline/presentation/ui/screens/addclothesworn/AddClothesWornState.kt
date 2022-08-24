package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.uimodel.ClothesUiModel
import java.time.LocalDate

data class AddClothesWornState (
    val date: LocalDate = LocalDate.now(),
    val clothesUiModelsList: List<ClothesUiModel> = emptyList()
)