package com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases

import com.trevorwiebe.clothesline.domain.model.OutfitModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetOutfitsByDateUC(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<OutfitModel>>{
        return repository.getOutfitByDate(date)
    }
}