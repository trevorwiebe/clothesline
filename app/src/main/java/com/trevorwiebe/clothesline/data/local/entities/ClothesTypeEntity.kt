package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes_type")
data class ClothesTypeEntity(
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Int? = null,
    val name: String
)
