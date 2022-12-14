package com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow

class GetClothesUC(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(): Flow<List<ClothesModel>>{
        return repository.getClothes()
    }
}