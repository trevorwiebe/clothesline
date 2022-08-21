package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.trevorwiebe.clothesline.data.local.entities.ClothesCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothesCategoryDao {

    @Query("SELECT * FROM clothes_category")
    fun getClothesCategory(): Flow<List<ClothesCategoryEntity>>

    @Query("SELECT * FROM clothes_category WHERE primaryKey = :id")
    fun getClothesCategoryByID(id: Int): Flow<ClothesCategoryEntity>

    @Insert
    suspend fun insertClothesCategory(clothesCategoryEntity: ClothesCategoryEntity)

    @Delete
    suspend fun deleteClothesCategory(clothesCategoryEntity: ClothesCategoryEntity)
}