package com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

class AddClothesUC(
    private val repository: ClothesLineRepository
) {
    suspend operator fun invoke(
        clothesModel: ClothesModel
    ){
        repository.insertClothes(clothesModel)
    }
}