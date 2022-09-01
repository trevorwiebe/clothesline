package com.trevorwiebe.clothesline.domain.model

data class OutfitAndClothesWornModel (
    val outfitModel: OutfitModel,
    val clothesWornList: List<ClothesWornModel>
)