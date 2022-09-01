package com.trevorwiebe.clothesline.domain.di

import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import com.trevorwiebe.clothesline.domain.use_cases.ParseCurrencyToLong
import com.trevorwiebe.clothesline.domain.use_cases.manageclothesworn_usecases.*
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.*
import com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases.*
import com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ClothesLineDomainModule {

    @ViewModelScoped
    @Provides
    fun provideClothesLine_ParseCurrencyToLong(): ParseCurrencyToLong{
        return ParseCurrencyToLong()
    }

    @ViewModelScoped
    @Provides
    fun provideClothesLine_AddClothesWornUseCases(
        repository: ClothesLineRepository
    ): ManageClothesWornUseCases {
        return ManageClothesWornUseCases(
            addClothesWornUC = AddClothesWornUC(repository),
            deleteClothesWornUC = DeleteClothesWornUC(repository),
            addClothesWornListUC = AddClothesWornListUC(repository),
            getClothesWorn = GetClothesWorn(repository)
        )
    }

    @ViewModelScoped
    @Provides
    fun provideClothesLine_ManageClothesUseCases(
        repository: ClothesLineRepository
    ): ManageClothesUseCases {
        return ManageClothesUseCases(
            addClothesUC = AddClothesUC(repository),
            getClothesUC = GetClothesUC(repository),
            getClothesByClothesCategoryIdUC = GetClothesByClothesCategoryIdUC(repository),
            calculateClothesWorthUC = CalculateClothesWorthUC()
        )
    }

    @ViewModelScoped
    @Provides
    fun provideClothesLine_ManageClothesCategoriesUseCases(
        repository: ClothesLineRepository
    ): ManageClothesCategoryUseCases {
        return ManageClothesCategoryUseCases(
            addClothesCategoryUC = AddClothesCategoryUC(repository),
            getClothesCategoryUC = GetClothesCategoryUC(repository),
            deleteClothesCategoryUC = DeleteClothesCategoryUC(repository),
            getClothesCategoryByIdUC = GetClothesCategoryByIdUC(repository),
            getClothesCategoriesAndClothesUC = GetClothesCategoriesAndClothesUC(repository)
        )
    }

    @ViewModelScoped
    @Provides
    fun provideClothesLine_OutfitUseCases(
        repository: ClothesLineRepository
    ): OutfitUseCases {
        return OutfitUseCases(
            getOutfitByIdUC = GetOutfitByIdUC(repository),
            getOutfitsAndClothesWornByDateUC = GetOutfitsAndClothesWornByDateUC(repository),
            insertOutfitAndClothesWornListUC = InsertOutfitAndClothesWornListUC(repository),
            getOutfitsByDateUC = GetOutfitsByDateUC(repository)
        )
    }

}