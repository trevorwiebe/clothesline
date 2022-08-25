package com.trevorwiebe.clothesline.domain.model

import java.time.LocalDate

data class OutfitModel(
    val primaryKey: Int = 0,
    val name: String,
    val date: LocalDate
)
