package com.trevorwiebe.clothesline.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trevorwiebe.clothesline.data.local.dao.ClothesDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesTypeDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesWornDao
import com.trevorwiebe.clothesline.data.local.dao.OutfitDao
import com.trevorwiebe.clothesline.data.local.entities.ClothesEntity
import com.trevorwiebe.clothesline.data.local.entities.ClothesTypeEntity
import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity
import com.trevorwiebe.clothesline.data.local.entities.OutfitEntity

@Database(
    entities = [
        ClothesWornEntity::class,
        ClothesTypeEntity::class,
        ClothesEntity::class,
        OutfitEntity::class
               ],
    version = 1,
    exportSchema = true
)
abstract class ClothesLineDatabase : RoomDatabase() {

    abstract fun clothesWornDao(): ClothesWornDao
    abstract fun clothesDao(): ClothesDao
    abstract fun clothesTypeDao(): ClothesTypeDao
    abstract fun outfitDao(): OutfitDao

}