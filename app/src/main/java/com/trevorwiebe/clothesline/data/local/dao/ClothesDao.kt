package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.*
import com.trevorwiebe.clothesline.data.local.entities.ClothesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClothes(clothesEntity: ClothesEntity)

    @Query("SELECT * FROM clothes")
    fun getClothes(): Flow<List<ClothesEntity>>

    @Delete
    suspend fun deleteClothes(clothesEntity: ClothesEntity)
}