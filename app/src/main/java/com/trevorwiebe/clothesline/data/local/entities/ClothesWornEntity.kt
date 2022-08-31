package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes_worn")
data class ClothesWornEntity(
    @PrimaryKey(autoGenerate = true)
    val clothesWornPrimaryKey: Int = 0,
    val clothesWornClothesModelId: Int,
    val clothesWornOutfitId: Int,
    val clothesWornDateDay: Int,
    val clothesWornDateMonth: Int,
    val clothesWornDateYear: Int,
    val clothesWornDeleted: Int
)
