package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.OutfitEntity
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import java.time.LocalDate

fun OutfitEntity.toOutfitModel(): OutfitModel{
    return OutfitModel(
        primaryKey = primaryKey,
        name = name,
        date = LocalDate.of(dateYear, dateMonth, dateDay)
    )
}

fun OutfitModel.toOutfitEntity(): OutfitEntity{
    return OutfitEntity(
        primaryKey = primaryKey,
        name = name,
        dateYear = date.year,
        dateMonth = date.monthValue,
        dateDay = date.dayOfMonth
    )
}