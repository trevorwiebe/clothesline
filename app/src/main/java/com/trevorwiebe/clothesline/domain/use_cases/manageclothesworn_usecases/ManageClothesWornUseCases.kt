package com.trevorwiebe.clothesline.domain.use_cases.manageclothesworn_usecases

data class ManageClothesWornUseCases(
    val addClothesWornUC: AddClothesWornUC,
    val addClothesWornListUC: AddClothesWornListUC,
    val deleteClothesWornUC: DeleteClothesWornUC,
    val getClothesWorn: GetClothesWorn
)
