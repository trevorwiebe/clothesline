package com.trevorwiebe.clothesline.domain.repository

import com.trevorwiebe.clothesline.domain.model.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ClothesLineRepository {

    // Clothes
    suspend fun insertClothes(clothes: ClothesModel)

    fun getClothes(): Flow<List<ClothesModel>>

    fun getClothesByClothesTypeId(id: Int): Flow<List<ClothesModel>>

    suspend fun deleteClothesType(clothes: ClothesModel)



    // Clothes Worn
    suspend fun insertClothesWorn(clothesWorn: ClothesWornModel)

    fun getClothesWorn(date: LocalDate): Flow<List<ClothesWornModel>>

    suspend fun deleteClothesWorn(clothesWorn: ClothesWornModel)

    suspend fun insertClothesWornList(clothesWornList: List<ClothesWornModel>)



    // Clothes Types
    suspend fun insertClothesType(clothesCategoryModel: ClothesCategoryModel)

    suspend fun deleteClothesType(clothesCategoryModel: ClothesCategoryModel)

    fun getClothesTypes(): Flow<List<ClothesCategoryModel>>

    fun getClothesTypeById(id: Int): Flow<ClothesCategoryModel>

    fun getClothesCategoryAndClothes(): Flow<Map<ClothesCategoryModel, List<ClothesModel>>>



    // Outfit
    suspend fun insertOutfitAndClothesWorn(outfitModel: OutfitModel, clothesWornList: List<ClothesWornModel>)

    fun getOutfitById(id: Int): Flow<OutfitModel>

    fun getOutfitsAndClothesWornByDate(date: LocalDate): Flow<List<OutfitAndClothesWornModel>>
}