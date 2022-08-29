package com.trevorwiebe.clothesline.domain.model

import java.time.LocalDate

data class OutfitModel (
    val outfitPrimaryKey: Int,
    val date: LocalDate,
    val deleted: Boolean
)