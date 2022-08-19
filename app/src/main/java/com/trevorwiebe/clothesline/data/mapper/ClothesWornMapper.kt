package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import java.time.LocalDate

fun ClothesWornEntity.toClothesWornModel(): ClothesWornModel{
    return ClothesWornModel(
        primaryKey = primaryKey,
        name = name,
        friendlyId = friendlyId,
        imageURL = imageURL,
        // FIXME: I don't think this is right
        clothesType = ClothesTypeModel(null, clothesType)
    )
}

fun ClothesWornModel.toClothesWornEntity(): ClothesWornEntity {
    return ClothesWornEntity(
        primaryKey = primaryKey,
        name = name,
        friendlyId = friendlyId,
        imageURL = imageURL,
        clothesType = clothesType.name,
    )
}