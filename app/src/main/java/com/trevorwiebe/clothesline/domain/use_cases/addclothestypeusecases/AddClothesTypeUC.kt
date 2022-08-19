package com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

class AddClothesTypeUC (
    private val repository: ClothesLineRepository
){
    suspend operator fun invoke(
        name: String
    ){
        repository.insertClothesType(
            ClothesTypeModel(null, name)
        )
    }
}