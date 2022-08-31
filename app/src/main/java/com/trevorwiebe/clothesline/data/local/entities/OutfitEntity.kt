package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "outfit")
data class OutfitEntity (
    @PrimaryKey(autoGenerate = true)
    val outfitPrimaryKey: Int,
    val outfitDateWornDay: Int,
    val outfitDateWornMonth: Int,
    val outfitDateWornYear: Int,
    val outfitDeleted: Boolean
)