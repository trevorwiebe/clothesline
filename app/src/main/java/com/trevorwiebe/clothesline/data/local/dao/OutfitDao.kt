package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.trevorwiebe.clothesline.data.local.entities.OutfitEntity
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OutfitDao {

    @Insert
    suspend fun insertDao(outfitEntity: OutfitEntity)

    @Query("SELECT * FROM outfit WHERE outfitPrimaryKey = :outfitId")
    fun getOutfitById(outfitId: Int): Flow<OutfitEntity>
}