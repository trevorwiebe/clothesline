package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.*
import com.trevorwiebe.clothesline.data.local.entities.ClothesTypeEntity
import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothesWornDao {

    @Query("SELECT * FROM clothes_worn " +
            "WHERE dateWornDay = :day AND dateWornMonth = :month AND dateWornYear = :year " +
            "GROUP BY clothes_worn.name")
    fun getClothesWornByDate(day: Int, month: Int, year: Int): Flow<List<ClothesWornEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClothesWorn(clothesWornEntity: ClothesWornEntity)

    @Delete
    suspend fun deleteClothesWorn(clothesWornEntity: ClothesWornEntity)
}