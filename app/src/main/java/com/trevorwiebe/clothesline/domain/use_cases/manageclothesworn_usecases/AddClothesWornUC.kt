package com.trevorwiebe.clothesline.domain.use_cases.manageclothesworn_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

data class AddClothesWornUC(
    private val repository: ClothesLineRepository
){
    suspend operator fun invoke(clothesWornModel: ClothesWornModel){
        repository.insertClothesWorn(clothesWornModel)
    }
}