package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "outfit")
data class OutfitEntity(
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Int? = null,
    val name: String,
    val dateDay: Int,
    val dateMonth: Int,
    val dateYear: Int
)
