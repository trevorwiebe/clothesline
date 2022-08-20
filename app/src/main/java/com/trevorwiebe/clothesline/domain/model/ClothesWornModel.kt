package com.trevorwiebe.clothesline.domain.model

data class ClothesWornModel(
    val primaryKey: Int?,
    val name: String,
    val friendlyId: String,
    val imageURL: String,
    val clothesType: ClothesCategoryModel,
    val outfitModel: Int
)
