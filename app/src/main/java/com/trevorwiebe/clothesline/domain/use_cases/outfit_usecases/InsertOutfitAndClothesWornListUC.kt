package com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

class InsertOutfitAndClothesWornListUC(
    private val repository: ClothesLineRepository
) {
    suspend operator fun invoke(outfit: OutfitModel, clothesWornList: List<ClothesWornModel>) {
        repository.insertOutfitAndClothesWorn(outfit, clothesWornList)
    }
}