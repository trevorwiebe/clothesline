package com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

data class DeleteClothesCategoryUC(
    private val repository: ClothesLineRepository
){
    suspend operator fun invoke(
        clothesCategoryModel: ClothesCategoryModel
    ){
        repository.deleteClothesType(clothesCategoryModel)
    }
}
