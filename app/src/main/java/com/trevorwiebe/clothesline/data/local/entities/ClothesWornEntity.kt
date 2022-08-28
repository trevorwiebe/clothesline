package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes_worn")
data class ClothesWornEntity(
    @PrimaryKey(autoGenerate = true)
    val clothesWornPrimaryKey: Int = 0,
    val clothesModelId: Int = 0,
    val dateDay: Int,
    val dateMonth: Int,
    val dateYear: Int,
    val deleted: Int
)
