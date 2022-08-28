package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes_category")
data class ClothesCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val clothesCategoryPrimaryKey: Int = 0,
    val clothesCategoryName: String,
    val deleted: Int
)
