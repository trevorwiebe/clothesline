package com.trevorwiebe.clothesline.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.trevorwiebe.clothesline.data.local.dao.ClothesDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesCategoryDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesWornDao
import com.trevorwiebe.clothesline.data.local.dao.OutfitDao
import com.trevorwiebe.clothesline.data.local.entities.*

@Database(
    entities = [
        ClothesWornEntity::class,
        ClothesCategoryEntity::class,
        ClothesEntity::class,
        OutfitEntity::class
               ],
    version = 1,
    exportSchema = true
)
abstract class ClothesLineDatabase : RoomDatabase() {

    abstract fun clothesWornDao(): ClothesWornDao
    abstract fun clothesDao(): ClothesDao
    // TODO rename this appropriately
    abstract fun clothesModelDao(): ClothesCategoryDao
    abstract fun outfitDao(): OutfitDao

}