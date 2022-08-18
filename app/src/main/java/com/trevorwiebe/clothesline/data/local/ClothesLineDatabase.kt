package com.trevorwiebe.clothesline.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trevorwiebe.clothesline.data.local.dao.ClothesTypeDao
import com.trevorwiebe.clothesline.data.local.dao.ClothesWornDao
import com.trevorwiebe.clothesline.data.local.entities.ClothesTypeEntity
import com.trevorwiebe.clothesline.data.local.entities.ClothesWornEntity

@Database(
    entities = [
        ClothesWornEntity::class,
        ClothesTypeEntity::class,
               ],
    version = 1,
    exportSchema = true
)
abstract class ClothesLineDatabase : RoomDatabase() {

    abstract fun clothesWornDao(): ClothesWornDao
    abstract fun clothesTypeDao(): ClothesTypeDao
}