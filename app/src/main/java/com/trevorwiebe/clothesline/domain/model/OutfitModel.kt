package com.trevorwiebe.clothesline.domain.model

import java.time.LocalDate

data class OutfitModel(
    val primaryKey: Int?,
    val name: String,
    val date: LocalDate
)
