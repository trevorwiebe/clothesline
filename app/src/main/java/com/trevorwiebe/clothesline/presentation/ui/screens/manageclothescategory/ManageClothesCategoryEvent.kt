package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothescategory

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel

sealed class ManageClothesCategoryEvent{
    data class OnClothesCategoryAdded(val name: String): ManageClothesCategoryEvent()
    data class OnClothesCategoryChange(val name: String): ManageClothesCategoryEvent()
    data class OnClothesCategoryDelete(val clothesCategoryModel: ClothesCategoryModel): ManageClothesCategoryEvent()
}
