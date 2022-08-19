package com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow

class GetClothesTypeUC(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(): Flow<List<ClothesTypeModel>> {
        return repository.getClothesTypes()
    }
}