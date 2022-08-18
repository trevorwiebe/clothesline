package com.trevorwiebe.clothesline.data.repository

import android.util.Log
import com.trevorwiebe.clothesline.data.local.dao.ClothesTypeDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesWornDao
import com.trevorwiebe.clothesline.data.mapper.toClothesTypeEntity
import com.trevorwiebe.clothesline.data.mapper.toClothesTypeModel
import com.trevorwiebe.clothesline.data.mapper.toClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ClothesLineRepositoryImpl(
    private val clothesWornDao: ClothesWornDao,
    private val clothesTypeDao: ClothesTypeDao
): ClothesLineRepository {

    override suspend fun insertClothesWorn(clothesWorn: ClothesWornModel) {
        clothesWornDao.insertClothesWorn(clothesWorn.toClothesWornEntity())
    }

    override suspend fun insertClothesType(clothesTypeModel: ClothesTypeModel) {
        clothesTypeDao.insertClothesType(clothesTypeModel.toClothesTypeEntity())
    }

    override fun getClothesTypes(): Flow<List<ClothesTypeModel>> {
        return clothesTypeDao.getClothesTypes()
            .map { entities ->
                entities.map {it.toClothesTypeModel()}
            }
    }
}