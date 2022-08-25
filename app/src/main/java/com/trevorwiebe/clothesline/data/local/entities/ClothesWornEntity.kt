package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes_worn")
data class ClothesWornEntity(
    @PrimaryKey(autoGenerate = true)
    val clothesWornPrimaryKey: Int = 0,
    val name: String,
    val friendlyId: String,
    val imageURL: String,
    val clothesType: String,
    val outfitId: Int
)
