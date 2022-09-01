package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.OutfitWithClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.OutfitAndClothesWornModel

fun OutfitWithClothesWornEntity.toOutfitWithClothesWornModel(): OutfitAndClothesWornModel{
    return OutfitAndClothesWornModel(
        outfitModel = outfitEntity.toOutfitModel(),
        clothesWornList = clothesWorn.map { it.toClothesWornModel() }
    )
}