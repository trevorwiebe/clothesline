package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesTypeEntity
import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.presentation.navigation.BottomNavScreen

fun ClothesTypeModel.toClothesTypeEntity(): ClothesTypeEntity {
    return ClothesTypeEntity(
        primaryKey = primaryKey,
        name = name
    )
}

fun ClothesTypeEntity.toClothesTypeModel(): ClothesTypeModel {
    return ClothesTypeModel(
        primaryKey = primaryKey,
        name = name
    )
}