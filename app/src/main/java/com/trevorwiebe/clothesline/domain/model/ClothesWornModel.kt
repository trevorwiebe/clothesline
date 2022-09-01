package com.trevorwiebe.clothesline.domain.model

import java.time.LocalDate

data class ClothesWornModel(
    val clothesWornPrimaryKey: Int = 0,
    val clothesModelId: Int,
    val outfitId: Long,
    val dateAdded: LocalDate,
    val deleted: Boolean
)
