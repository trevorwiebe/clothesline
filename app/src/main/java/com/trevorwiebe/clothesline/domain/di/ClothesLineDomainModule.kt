package com.trevorwiebe.clothesline.domain.di

import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import com.trevorwiebe.clothesline.domain.use_cases.ParseCurrencyToLong
import com.trevorwiebe.clothesline.domain.use_cases.addclothesworn_usecases.AddClothesWornListUC
import com.trevorwiebe.clothesline.domain.use_cases.addclothesworn_usecases.AddClothesWornUC
import com.trevorwiebe.clothesline.domain.use_cases.addclothesworn_usecases.AddClothesWornUseCases
import com.trevorwiebe.clothesline.domain.use_cases.addclothesworn_usecases.DeleteClothesWornUC
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.*
import com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases.*
import com.trevorwiebe.clothesline.domain.use_cases.viewclotheswornusecases.ViewClothesUseCases
import com.trevorwiebe.clothesline.domain.use_cases.viewclotheswornusecases.GetClothesWorn
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
    ): AddClothesWornUseCases {
        return AddClothesWornUseCases(
            addClothesWornUC = AddClothesWornUC(repository),
            deleteClothesWornUC = DeleteClothesWornUC(repository),
            addClothesWornListUC = AddClothesWornListUC(repository)
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
    fun provideClothesLine_ViewClothesUseCases(
        repository: ClothesLineRepository
    ): ViewClothesUseCases{
        return ViewClothesUseCases(
            getClothesWorn = GetClothesWorn(repository)
        )
    }
}