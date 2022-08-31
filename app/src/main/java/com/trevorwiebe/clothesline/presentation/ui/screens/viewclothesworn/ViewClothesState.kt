package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import java.time.LocalDate

data class ViewClothesState(
    val isSearching: Boolean = false,
    val clothesWornList: List<ClothesWornModel> = emptyList(),
    val outfitList: List<OutfitModel> = emptyList(),
    val date: LocalDate = LocalDate.now()
)
