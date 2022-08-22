package com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases

data class ManageClothesUseCases (
    val getClothesUC: GetClothesUC,
    val getClothesByClothesCategoryIdUC: GetClothesByClothesCategoryIdUC,
    val addClothesUC: AddClothesUC,
    val calculateClothesWorthUC: CalculateClothesWorthUC
)