package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import java.time.LocalDate

fun ClothesWornModel.toClothesWornEntity(): ClothesWornEntity {
    return ClothesWornEntity(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesWornClothesModelId = clothesModelId,
        clothesWornOutfitId = outfitId,
        clothesWornDateDay = dateAdded.dayOfMonth,
        clothesWornDateMonth = dateAdded.monthValue,
        clothesWornDateYear = dateAdded.year,
        clothesWornDeleted = if(deleted) 1 else 0
    )
}

fun ClothesWornEntity.toClothesWornModel(): ClothesWornModel{
    return ClothesWornModel(
        clothesWornPrimaryKey = clothesWornPrimaryKey,
        clothesModelId = clothesWornClothesModelId,
        outfitId = clothesWornOutfitId,
        dateAdded = LocalDate.of(clothesWornDateYear, clothesWornDateMonth, clothesWornDateDay),
        deleted = clothesWornDeleted != 1
    )
}