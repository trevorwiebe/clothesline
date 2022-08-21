package com.trevorwiebe.clothesline.domain.model

import java.time.LocalDate

data class ClothesModel(
    val primaryKey: Int?,
    val name: String,
    val clothesTypeId: Int,
    val friendlyId: String,
    val imageUrl: String?,
    val datePurchased: LocalDate,
    val cost: Long
)
