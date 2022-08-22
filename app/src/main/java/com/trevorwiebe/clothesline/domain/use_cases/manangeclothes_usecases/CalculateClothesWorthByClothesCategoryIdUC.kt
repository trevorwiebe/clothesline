package com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesModel

class CalculateClothesWorthUC() {
    operator fun invoke(clothesList: List<ClothesModel>): Long {
        var total: Long = 0
        clothesList.onEach { clothesModel ->
            total = total.plus(clothesModel.cost)
        }
        return total
    }
}