package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.*
import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothesWornDao {

    @Query("SELECT * FROM clothes_worn")
    fun getClothesWornByDate(): Flow<List<ClothesWornEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClothesWorn(clothesWornEntity: ClothesWornEntity)

    @Query("DELETE FROM clothes_worn WHERE clothes_worn.clothesModelId = :clothesModelId")
    suspend fun deleteClothesWorn(clothesModelId: Int)
}