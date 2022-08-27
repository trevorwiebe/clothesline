package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import java.time.LocalDate

fun ClothesWornEntity.toClothesWornModel(): ClothesWornModel{
    return ClothesWornModel(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesModelId = clothesModelId,
        dateAdded = LocalDate.of(dateYear, dateMonth, dateDay)
    )
}

fun ClothesWornModel.toClothesWornEntity(): ClothesWornEntity {
    return ClothesWornEntity(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesModelId = clothesModelId,
        dateDay = dateAdded.dayOfMonth,
        dateMonth = dateAdded.monthValue,
        dateYear = dateAdded.year
    )
}