package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesCategoryEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel

fun ClothesCategoryModel.toClothesTypeEntity(): ClothesCategoryEntity {
    return ClothesCategoryEntity(
        primaryKey = primaryKey,
        name = name
    )
}

fun ClothesCategoryEntity.toClothesTypeModel(): ClothesCategoryModel {
    return ClothesCategoryModel(
        primaryKey = primaryKey,
        name = name
    )
}