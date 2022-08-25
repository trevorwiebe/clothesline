package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel

fun ClothesWornEntity.toClothesWornModel(): ClothesWornModel{
    return ClothesWornModel(
        primaryKey = clothesWornPrimaryKey,
        name = name,
        friendlyId = friendlyId,
        imageURL = imageURL,
        // FIXME: I don't think this is right
        clothesType = ClothesCategoryModel(0, clothesType),
        outfitModel = outfitId
    )
}

fun ClothesWornModel.toClothesWornEntity(): ClothesWornEntity {
    return ClothesWornEntity(
        clothesWornPrimaryKey = primaryKey,
        name = name,
        friendlyId = friendlyId,
        imageURL = imageURL,
        clothesType = clothesType.name,
        outfitId = outfitModel
    )
}