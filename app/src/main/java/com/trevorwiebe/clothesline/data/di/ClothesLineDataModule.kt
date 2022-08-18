package com.trevorwiebe.clothesline.data.di

import android.app.Application
import androidx.room.Room
import com.trevorwiebe.clothesline.data.local.ClothesLineDatabase
import com.trevorwiebe.clothesline.data.repository.ClothesLineRepositoryImpl
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClothesLineDataModule {

    @Provides
    @Singleton
    fun provideClothesLineDatabase(app: Application): ClothesLineDatabase{
        return Room.databaseBuilder(
            app,
            ClothesLineDatabase::class.java,
            "clothes_line_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideClothesLineRepository(
        db: ClothesLineDatabase
    ): ClothesLineRepository {
        return ClothesLineRepositoryImpl(
            clothesTypeDao = db.clothesTypeDao(),
            clothesWornDao = db.clothesWornDao(),
        )
    }
}