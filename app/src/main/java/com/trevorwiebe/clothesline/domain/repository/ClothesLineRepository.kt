package com.trevorwiebe.clothesline.domain.repository

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import kotlinx.coroutines.flow.Flow

interface ClothesLineRepository {

    suspend fun insertClothesWorn(clothesWorn: ClothesWornModel)

    suspend fun insertClothesType(clothesTypeModel: ClothesTypeModel)

    fun getClothesTypes(): Flow<List<ClothesTypeModel>>
}