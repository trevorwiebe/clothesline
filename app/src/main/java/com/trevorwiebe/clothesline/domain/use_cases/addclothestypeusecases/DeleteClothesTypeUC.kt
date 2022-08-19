package com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

data class DeleteClothesTypeUC(
    private val repository: ClothesLineRepository
){
    suspend operator fun invoke(
        clothesTypeModel: ClothesTypeModel
    ){
        repository.deleteClothesType(clothesTypeModel)
    }
}
