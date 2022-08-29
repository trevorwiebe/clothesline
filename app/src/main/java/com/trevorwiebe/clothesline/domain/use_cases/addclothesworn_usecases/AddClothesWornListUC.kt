package com.trevorwiebe.clothesline.domain.use_cases.addclothesworn_usecases

import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository

class AddClothesWornListUC(
    private val repository: ClothesLineRepository
) {
    suspend operator fun invoke(clothesWornModelList: List<ClothesWornModel>){
        repository.insertClothesWornList(clothesWornModelList)
    }
}