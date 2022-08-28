package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes")
data class ClothesEntity (
    @PrimaryKey(autoGenerate = true)
    val clothesEntityPrimaryKey: Int = 0,
    val clothesTypeId: Int,
    val clothesName: String,
    val friendlyId: String,
    val imageURL: String?,
    val datePurchasedDay: Int,
    val datePurchasedMonth: Int,
    val datePurchasedYear: Int,
    val cost: Long,
    val deleted: Int
)