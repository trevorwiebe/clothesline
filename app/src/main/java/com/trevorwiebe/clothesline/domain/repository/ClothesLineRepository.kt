package com.trevorwiebe.clothesline.domain.repository

import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ClothesLineRepository {

    // Clothes Worn
    suspend fun insertClothesWorn(clothesWorn: ClothesWornModel)

    fun getClothesWorn(date: LocalDate): Flow<List<ClothesWornModel>>



    // Clothes Types
    suspend fun insertClothesType(clothesTypeModel: ClothesTypeModel)

    fun getClothesTypes(): Flow<List<ClothesTypeModel>>
}