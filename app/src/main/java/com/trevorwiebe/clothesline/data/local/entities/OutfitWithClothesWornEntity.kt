package com.trevorwiebe.clothesline.data.local.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class OutfitWithClothesWornEntity(
    @Embedded val outfitEntity: OutfitEntity,
    @Relation(
        parentColumn = "outfitPrimaryKey",
        entityColumn = "clothesWornOutfitId",
    )
    val clothesWorn: List<ClothesWornEntity>
)
