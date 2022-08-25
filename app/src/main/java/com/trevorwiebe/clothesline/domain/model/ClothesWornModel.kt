package com.trevorwiebe.clothesline.domain.model

data class ClothesWornModel(
    val primaryKey: Int = 0,
    val name: String,
    val friendlyId: String,
    val imageURL: String,
    val clothesType: ClothesCategoryModel,
    val outfitModel: Int
)
