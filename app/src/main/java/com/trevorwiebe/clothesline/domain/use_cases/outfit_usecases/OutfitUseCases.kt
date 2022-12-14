package com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases

data class OutfitUseCases (
    val getOutfitByIdUC: GetOutfitByIdUC,
    val getOutfitsByDateUC: GetOutfitsByDateUC,
    val getOutfitsAndClothesWornByDateUC: GetOutfitsAndClothesWornByDateUC,
    val insertOutfitAndClothesWornListUC: InsertOutfitAndClothesWornListUC
)