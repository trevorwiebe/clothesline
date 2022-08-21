package com.trevorwiebe.clothesline.domain.repository

import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ClothesLineRepository {

    // Clothes
    suspend fun insertClothes(clothes: ClothesModel)

    fun getClothes(): Flow<List<ClothesModel>>

    suspend fun deleteClothesType(clothes: ClothesModel)



    // Clothes Worn
    suspend fun insertClothesWorn(clothesWorn: ClothesWornModel)

    fun getClothesWorn(date: LocalDate): Flow<List<ClothesWornModel>>



    // Clothes Types
    suspend fun insertClothesType(clothesCategoryModel: ClothesCategoryModel)

    suspend fun deleteClothesType(clothesCategoryModel: ClothesCategoryModel)

    fun getClothesTypes(): Flow<List<ClothesCategoryModel>>

    fun getClothesTypeById(id: Int): Flow<ClothesCategoryModel>
}