package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.PrimaryKey

data class OutfitEntity (
    @PrimaryKey(autoGenerate = true)
    val outfitPrimaryKey: Int,
    val dateWornDay: Int,
    val dateWornMonth: Int,
    val dateWornYear: Int,
    val deleted: Boolean
)