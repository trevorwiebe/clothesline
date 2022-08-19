package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.trevorwiebe.clothesline.data.local.entities.OutfitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OutfitDao {

    @Insert
    suspend fun insertOutfit(outfitEntity: OutfitEntity)

    @Query("SELECT * FROM outfit")
    fun getAllOutFits(): Flow<List<OutfitEntity>>

    @Delete
    suspend fun deleteOutfit(outfitEntity: OutfitEntity)
}