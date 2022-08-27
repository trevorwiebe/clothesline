package com.trevorwiebe.clothesline.domain.model

import java.time.LocalDate

data class ClothesWornModel(
    val clothesWornPrimaryKey: Int = 0,
    val clothesModelId: Int,
    val dateAdded: LocalDate
)
