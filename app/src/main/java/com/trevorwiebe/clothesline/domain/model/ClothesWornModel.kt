package com.trevorwiebe.clothesline.domain.model

import java.time.LocalDate

data class ClothesWornModel(
    val primaryKey: Int?,
    val name: String,
    val friendlyId: String,
    val imageURL: String,
    val clothesType: ClothesTypeModel
)
