package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothescategory

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel

data class ManageClothesCategoryState(
    val clothesTypeString: String = "",
    val clothesTypesList: List<ClothesCategoryModel> = emptyList()
)
