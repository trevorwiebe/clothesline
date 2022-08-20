package com.trevorwiebe.clothesline.data.repository

import com.trevorwiebe.clothesline.data.local.dao.ClothesCategoryDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesWornDao
import com.trevorwiebe.clothesline.data.mapper.toClothesTypeEntity
import com.trevorwiebe.clothesline.data.mapper.toClothesTypeModel
import com.trevorwiebe.clothesline.data.mapper.toClothesWornEntity
import com.trevorwiebe.clothesline.data.mapper.toClothesWornModel
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class ClothesLineRepositoryImpl(
    private val clothesWornDao: ClothesWornDao,
    private val clothesCategoryDao: ClothesCategoryDao
): ClothesLineRepository {

    override suspend fun insertClothesWorn(clothesWorn: ClothesWornModel) {
        clothesWornDao.insertClothesWorn(clothesWorn.toClothesWornEntity())
    }

    override fun getClothesWorn(date: LocalDate):  Flow<List<ClothesWornModel>>{
        return clothesWornDao.getClothesWornByDate()
            .map { entities ->
                entities.map { it.toClothesWornModel() }
            }
    }

    override suspend fun insertClothesType(clothesCategoryModel: ClothesCategoryModel) {
        clothesCategoryDao.insertClothesCategory(clothesCategoryModel.toClothesTypeEntity())
    }

    override fun getClothesTypes(): Flow<List<ClothesCategoryModel>> {
        return clothesCategoryDao.getClothesCategory()
            .map { entities ->
                entities.map {it.toClothesTypeModel()}
            }
    }

    override suspend fun deleteClothesType(clothesCategoryModel: ClothesCategoryModel) {
        clothesCategoryDao.deleteClothesCategory(clothesCategoryModel.toClothesTypeEntity())
    }
}