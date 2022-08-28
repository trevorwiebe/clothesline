package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import java.time.LocalDate

fun ClothesWornModel.toClothesWornEntity(): ClothesWornEntity {
    return ClothesWornEntity(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesModelId = clothesModelId,
        dateDay = dateAdded.dayOfMonth,
        dateMonth = dateAdded.monthValue,
        dateYear = dateAdded.year,
        deleted = if(deleted) 1 else 0
    )
}

fun ClothesWornEntity.toClothesWornModel(): ClothesWornModel{
    return ClothesWornModel(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesModelId = clothesModelId,
        dateAdded = LocalDate.of(dateYear, dateMonth, dateDay),
        deleted = deleted != 1
    )
}