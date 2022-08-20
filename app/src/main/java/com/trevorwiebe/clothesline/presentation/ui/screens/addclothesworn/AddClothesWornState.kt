package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import java.time.LocalDate

data class AddClothesWornState (
    val date: LocalDate = LocalDate.now(),
    val clothesTypeList: List<ClothesCategoryModel> = emptyList()
)