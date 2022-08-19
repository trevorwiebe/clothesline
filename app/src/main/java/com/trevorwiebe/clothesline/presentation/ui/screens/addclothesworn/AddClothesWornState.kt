package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import java.time.LocalDate

data class AddClothesWornState (
    val date: LocalDate = LocalDate.now(),
    val clothesTypeList: List<ClothesTypeModel> = emptyList()
)