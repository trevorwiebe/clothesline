package com.trevorwiebe.clothesline.data.repository

import com.trevorwiebe.clothesline.data.local.dao.ClothesCategoryDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesWornDao
import com.trevorwiebe.clothesline.data.local.dao.OutfitDao
import com.trevorwiebe.clothesline.data.local.entities.ClothesCategoryEntity
import com.trevorwiebe.clothesline.data.local.entities.ClothesEntity
import com.trevorwiebe.clothesline.data.mapper.*
import com.trevorwiebe.clothesline.domain.model.*
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class ClothesLineRepositoryImpl(
    private val clothesWornDao: ClothesWornDao,
    private val clothesCategoryDao: ClothesCategoryDao,
    private val clothesDao: ClothesDao,
    private val outfitDao: OutfitDao
): ClothesLineRepository {

    // clothes
    override suspend fun insertClothes(clothes: ClothesModel) {
        clothesDao.insertClothes(clothes.toClothesEntity())
    }

    override fun getClothes(): Flow<List<ClothesModel>> {
        return clothesDao.getClothes()
            .map { entities ->
                entities.map { it.toClothesModel() }
            }
    }

    override suspend fun deleteClothesType(clothes: ClothesModel) {
        clothesDao.deleteClothes(clothes.toClothesEntity())
    }

    override fun getClothesByClothesTypeId(id: Int): Flow<List<ClothesModel>> {
        return clothesDao.getClothesByClothesTypeId(id)
            .map { entities ->
                entities.map {it.toClothesModel()}
            }
    }

    // clothes worn
    override suspend fun insertClothesWorn(clothesWorn: ClothesWornModel) {
        clothesWornDao.insertClothesWorn(clothesWorn.toClothesWornEntity())
    }

    override fun getClothesWorn(date: LocalDate):  Flow<List<ClothesWornModel>>{
        return clothesWornDao.getClothesWornByDate()
            .map { entities ->
                entities.map { it.toClothesWornModel() }
            }
    }

    override suspend fun deleteClothesWorn(clothesWorn: ClothesWornModel) {
        clothesWornDao.deleteClothesWorn(clothesWorn.clothesModelId)
    }

    override suspend fun insertClothesWornList(clothesWornList: List<ClothesWornModel>) {
        clothesWornDao.insertClothesWornList(clothesWornList.map { it.toClothesWornEntity() })
    }

    // clothes categories
    override suspend fun insertClothesType(clothesCategoryModel: ClothesCategoryModel) {
        clothesCategoryDao.insertClothesCategory(clothesCategoryModel.toClothesTypeEntity())
    }

    override fun getClothesTypes(): Flow<List<ClothesCategoryModel>> {
        return clothesCategoryDao.getClothesCategory()
            .map { entities ->
                entities.map {it.toClothesTypeModel()}
            }
    }

    override fun getClothesTypeById(id: Int): Flow<ClothesCategoryModel> {
        return clothesCategoryDao.getClothesCategoryByID(id)
            .map { it.toClothesTypeModel() }
    }

    override suspend fun deleteClothesType(clothesCategoryModel: ClothesCategoryModel) {
        clothesCategoryDao.deleteClothesCategory(clothesCategoryModel.toClothesTypeEntity())
    }

    override fun getClothesCategoryAndClothes(): Flow<Map<ClothesCategoryModel, List<ClothesModel>>> {
        val clothesMap: Flow<Map<ClothesCategoryEntity, List<ClothesEntity>>> = clothesCategoryDao.getClothesCategoryAndClothes()
        return clothesMap.map { map1 ->
                map1.mapKeys { clothesTM ->
                    clothesTM.key.toClothesTypeModel()
                }
            }
            .map { map2 ->
                map2.mapValues { clothesML ->
                    clothesML.value.map { clothesM ->
                    clothesM.toClothesModel() }
                }
            }
    }

    // outfit
    override suspend fun insertOutfitAndClothesWorn(
        outfitModel: OutfitModel,
        clothesWornList: List<ClothesWornModel>
    ) {
        outfitDao.insertOutfitAndClothesWornList(
            outfitModel.toOutfitEntity(),
            clothesWornList.map { it.toClothesWornEntity() }
        )
    }

    override fun getOutfitByDate(date: LocalDate): Flow<List<OutfitModel>> {
        return outfitDao.getOutfitsByDate(date.year, date.monthValue, date.dayOfMonth).map { outfitEntityList ->
            outfitEntityList.map { it.toOutfitModel() }
        }
    }

    override fun getOutfitById(id: Int): Flow<OutfitModel> {
        return outfitDao.getOutfitById(id).map { it.toOutfitModel() }
    }

    override fun getOutfitsAndClothesWornByDate(date: LocalDate): Flow<List<OutfitAndClothesWornModel>> {
        return outfitDao.getOutfitsAndClothesWornByDate(date.year, date.monthValue, date.dayOfMonth)
            .map { outfitClothesWornList ->
                outfitClothesWornList.map {
                    it.toOutfitWithClothesWornModel()
                }
            }
    }

}