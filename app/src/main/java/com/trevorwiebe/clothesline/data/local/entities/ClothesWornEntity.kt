package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes_worn")
data class ClothesWornEntity(
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Int? = null,
    val name: String,
    val friendlyId: String,
    val imageURL: String,
    val dateWornDay: Int,
    val dateWornMonth: Int,
    val dateWornYear: Int,
    val clothesType: String
)
