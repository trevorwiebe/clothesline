package com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases

import com.trevorwiebe.clothesline.domain.model.OutfitModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow

class GetOutfitByIdUC(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(id: Int): Flow<OutfitModel> {
        return repository.getOutfitById(id)
    }
}