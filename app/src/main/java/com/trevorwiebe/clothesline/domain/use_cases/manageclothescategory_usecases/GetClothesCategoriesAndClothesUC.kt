package com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow

class GetClothesCategoriesAndClothesUC(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(): Flow<Map<ClothesCategoryModel, List<ClothesModel>>> {
        return repository.getClothesCategoryAndClothes()
    }
}