package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel

fun ClothesWornEntity.toClothesWornModel(): ClothesWornModel{
    return ClothesWornModel(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesModelId = clothesModelId,
        outfitModel = outfitId
    )
}

fun ClothesWornModel.toClothesWornEntity(): ClothesWornEntity {
    return ClothesWornEntity(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesModelId = clothesModelId,
        outfitId = outfitModel
    )
}