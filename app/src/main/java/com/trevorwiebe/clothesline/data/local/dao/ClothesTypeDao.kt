package com.trevorwiebe.clothesline.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.trevorwiebe.clothesline.data.local.entities.ClothesTypeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClothesTypeDao {

    @Query("SELECT * FROM clothes_type")
    fun getClothesTypes(): Flow<List<ClothesTypeEntity>>

    @Query("SELECT * FROM clothes_type WHERE primaryKey = :id")
    fun getClothesTypeByID(id: Int): ClothesTypeEntity

    @Insert
    suspend fun insertClothesType(clothesTypeEntity: ClothesTypeEntity)

    @Delete
    suspend fun deleteClothesType(clothesTypeEntity: ClothesTypeEntity)
}