package com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases

import com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases.AddClothesTypeUC

data class AddClothesUseCases(
    val addClothesTypeUC: AddClothesTypeUC,
    val getClothesTypeUC: GetClothesTypes
)
