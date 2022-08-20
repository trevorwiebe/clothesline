package com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow

class GetClothesCategoryUC(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(): Flow<List<ClothesCategoryModel>> {
        return repository.getClothesTypes()
    }
}