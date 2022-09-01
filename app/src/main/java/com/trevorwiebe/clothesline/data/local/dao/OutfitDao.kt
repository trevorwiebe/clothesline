package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.trevorwiebe.clothesline.data.local.entities.OutfitEntity
import com.trevorwiebe.clothesline.data.local.entities.OutfitWithClothesWornEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OutfitDao {

    @Insert
    suspend fun insertDao(outfitEntity: OutfitEntity)

    @Query("SELECT * FROM outfit WHERE outfitPrimaryKey = :outfitId")
    fun getOutfitById(outfitId: Int): Flow<OutfitEntity>

    @Transaction
    @Query("SELECT * FROM outfit " +
            "WHERE outfitDateWornDay = :day " +
            "AND outfitDateWornMonth = :month " +
            "AND outfitDateWornYear = :year")
    fun getOutfitsAndClothesWornByDate(year: Int, month: Int, day: Int): Flow<List<OutfitWithClothesWornEntity>>

}