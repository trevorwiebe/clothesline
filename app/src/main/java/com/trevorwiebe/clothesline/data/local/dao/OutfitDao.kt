package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.data.local.entities.OutfitEntity
import com.trevorwiebe.clothesline.data.local.entities.OutfitWithClothesWornEntity
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OutfitDao {

    @Insert
    suspend fun insertOutfit(outfitEntity: OutfitEntity): Long

    @Insert
    suspend fun insertClothesWornList(clothesWorn: List<ClothesWornEntity>)

    @Query("SELECT * FROM outfit WHERE outfitPrimaryKey = :outfitId")
    fun getOutfitById(outfitId: Int): Flow<OutfitEntity>

    @Query("SELECT * FROM outfit " +
            "WHERE outfitDateWornDay = :day " +
            "AND outfitDateWornMonth = :month " +
            "AND outfitDateWornYear = :year")
    fun getOutfitsByDate(year: Int, month: Int, day: Int): Flow<List<OutfitEntity>>

    @Transaction
    @Query("SELECT * FROM outfit " +
            "WHERE outfitDateWornDay = :day " +
            "AND outfitDateWornMonth = :month " +
            "AND outfitDateWornYear = :year")
    fun getOutfitsAndClothesWornByDate(year: Int, month: Int, day: Int): Flow<List<OutfitWithClothesWornEntity>>

    @Transaction
    suspend fun insertOutfitAndClothesWornList(outfit: OutfitEntity, clothesWorn: List<ClothesWornEntity>){
        val outfit_id = insertOutfit(outfit)
        clothesWorn.forEach { it.clothesWornOutfitId = outfit_id}
        insertClothesWornList(clothesWorn)
    }

}