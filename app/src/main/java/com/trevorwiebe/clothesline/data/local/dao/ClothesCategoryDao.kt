package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.trevorwiebe.clothesline.data.local.entities.ClothesCategoryEntity
import com.trevorwiebe.clothesline.data.local.entities.ClothesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothesCategoryDao {

    @Query("SELECT * FROM clothes_category WHERE deleted = 0")
    fun getClothesCategory(): Flow<List<ClothesCategoryEntity>>

    @Query("SELECT * FROM clothes_category WHERE clothesCategoryPrimaryKey = :id")
    fun getClothesCategoryByID(id: Int): Flow<ClothesCategoryEntity>

    @Query("SELECT * FROM clothes_category LEFT JOIN clothes ON clothes_category.clothesCategoryPrimaryKey = clothes.clothesTypeId")
    fun getClothesCategoryAndClothes(): Flow<Map<ClothesCategoryEntity, List<ClothesEntity>>>

    @Insert
    suspend fun insertClothesCategory(clothesCategoryEntity: ClothesCategoryEntity)

    @Delete
    suspend fun deleteClothesCategory(clothesCategoryEntity: ClothesCategoryEntity)
}