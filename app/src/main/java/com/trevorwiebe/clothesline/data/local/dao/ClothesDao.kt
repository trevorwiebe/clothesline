package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.*
import com.trevorwiebe.clothesline.data.local.entities.ClothesEntity
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.GetClothesCategoryByIdUC
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClothes(clothesEntity: ClothesEntity)

    @Query("SELECT * FROM clothes")
    fun getClothes(): Flow<List<ClothesEntity>>

    @Query("SELECT * FROM clothes WHERE clothesTypeId = :clothesId")
    fun getClothesByClothesTypeId(clothesId: Int): Flow<List<ClothesEntity>>

    @Delete
    suspend fun deleteClothes(clothesEntity: ClothesEntity)
}