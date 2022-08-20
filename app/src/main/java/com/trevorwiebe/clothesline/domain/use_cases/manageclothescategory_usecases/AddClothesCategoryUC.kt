package com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

class AddClothesCategoryUC (
    private val repository: ClothesLineRepository
){
    suspend operator fun invoke(
        name: String
    ){
        repository.insertClothesType(
            ClothesCategoryModel(null, name)
        )
    }
}