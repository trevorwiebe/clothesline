package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clothes")
data class ClothesEntity (
    @PrimaryKey
    val primaryKey: Int?,
    val name: String,
    val friendlyId: String,
    val imageURL: String?,
    val datePurchasedDay: Int,
    val datePurchasedMonth: Int,
    val datePurchasedYear: Int,
    val cost: Long
)