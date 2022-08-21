package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import java.time.LocalDate

data class AddClothesState (
    val selectedClothesCategoryId: Int = 0,
    val selectedClothesCategoryModel: ClothesCategoryModel = ClothesCategoryModel(0, ""),
    val clothesCategoryList: List<ClothesCategoryModel> = emptyList(),
    val name: String = "",
    val friendlyId: String = "",
    val datePurchased: LocalDate = LocalDate.now(),
    val purchasedPrice: Long = 0
)
