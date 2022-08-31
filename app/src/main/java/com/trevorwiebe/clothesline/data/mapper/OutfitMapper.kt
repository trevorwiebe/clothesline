package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.OutfitEntity
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import java.time.LocalDate

fun OutfitModel.toOutfitEntity(): OutfitEntity {
    return OutfitEntity(
        outfitPrimaryKey = outfitPrimaryKey,
        outfitDateWornDay = date.dayOfMonth,
        outfitDateWornMonth = date.monthValue,
        outfitDateWornYear = date.year,
        outfitDeleted = deleted
    )
}

fun OutfitEntity.toOutfitModel(): OutfitModel {
    return OutfitModel(
        outfitPrimaryKey = outfitPrimaryKey,
        date = LocalDate.of(outfitDateWornYear, outfitDateWornMonth, outfitDateWornDay),
        deleted = outfitDeleted
    )
}