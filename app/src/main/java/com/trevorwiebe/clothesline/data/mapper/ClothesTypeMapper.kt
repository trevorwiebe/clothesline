package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesCategoryEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel

fun ClothesCategoryModel.toClothesTypeEntity(): ClothesCategoryEntity {
    return ClothesCategoryEntity(
        clothesCategoryPrimaryKey = primaryKey,
        clothesCategoryName = name
    )
}

fun ClothesCategoryEntity.toClothesTypeModel(): ClothesCategoryModel {
    return ClothesCategoryModel(
        primaryKey = clothesCategoryPrimaryKey,
        name = clothesCategoryName
    )
}