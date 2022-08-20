package com.trevorwiebe.clothesline.data.mapper

import com.trevorwiebe.clothesline.data.local.entities.ClothesEntity
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import java.time.LocalDate
import kotlin.math.cos

fun ClothesModel.toClothesEntity(): ClothesEntity{
    return ClothesEntity(
        primaryKey = primaryKey,
        name = name,
        friendlyId = friendlyId,
        imageURL = imageUrl,
        datePurchasedDay = datePurchased.dayOfMonth,
        datePurchasedMonth = datePurchased.monthValue,
        datePurchasedYear = datePurchased.year,
        cost = cost
    )
}

fun ClothesEntity.toClothesModel(): ClothesModel{
    return ClothesModel(
        primaryKey = primaryKey,
        name = name,
        friendlyId = friendlyId,
        imageUrl = imageURL,
        datePurchased = LocalDate.of(datePurchasedYear, datePurchasedMonth, datePurchasedDay),
        cost = cost
    )
}