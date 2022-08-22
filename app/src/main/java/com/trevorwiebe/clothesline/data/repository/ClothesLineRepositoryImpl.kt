package com.trevorwiebe.clothesline.data.repository

import com.trevorwiebe.clothesline.data.local.dao.ClothesCategoryDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesWornDao
import com.trevorwiebe.clothesline.data.local.dao.OutfitDao
import com.trevorwiebe.clothesline.data.mapper.*
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
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
}