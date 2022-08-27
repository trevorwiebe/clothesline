package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.uimodel.AddOutfitUiModel
import java.time.LocalDate

data class AddClothesWornState (
    val date: LocalDate = LocalDate.now(),
    val addOutfitUiModelsList: List<AddOutfitUiModel> = emptyList()
)