package com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases

data class ManageClothesCategoryUseCases(
    val addClothesCategoryUC: AddClothesCategoryUC,
    val getClothesCategoryUC: GetClothesCategoryUC,
    val deleteClothesCategoryUC: DeleteClothesCategoryUC
)