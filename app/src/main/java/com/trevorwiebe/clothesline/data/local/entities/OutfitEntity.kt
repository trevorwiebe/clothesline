package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "outfit")
data class OutfitEntity(
    @PrimaryKey(autoGenerate = true)
    val outfitEntityPrimaryKey: Int = 0,
    val name: String,
    val dateDay: Int,
    val dateMonth: Int,
    val dateYear: Int
)
