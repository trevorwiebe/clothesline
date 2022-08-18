package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import java.time.LocalDate

data class ViewClothesState(
    val isSearching: Boolean = false,
    val clothesWornList: List<ClothesWornModel> = emptyList(),
    val date: LocalDate = LocalDate.now()
)
