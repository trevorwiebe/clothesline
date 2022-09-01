package com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases

import com.trevorwiebe.clothesline.domain.model.OutfitAndClothesWornModel
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetOutfitsAndClothesWornByDateUC(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<OutfitAndClothesWornModel>> {
        return repository.getOutfitsAndClothesWornByDate(date)
    }
}