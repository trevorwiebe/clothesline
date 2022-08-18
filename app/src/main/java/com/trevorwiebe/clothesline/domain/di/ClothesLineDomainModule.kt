package com.trevorwiebe.clothesline.domain.di

import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases.AddClothesTypeUC
import com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases.AddClothesUseCases
import com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases.GetClothesTypes
import com.trevorwiebe.clothesline.domain.use_cases.viewclotheswornusecases.ViewClothesUseCases
import com.trevorwiebe.clothesline.domain.use_cases.viewclotheswornusecases.item.GetClothesWorn
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
    fun provideClothesLine_AddClothesUseCases(
        repository: ClothesLineRepository
    ): AddClothesUseCases {
        return AddClothesUseCases(
            addClothesTypeUC = AddClothesTypeUC(repository),
            getClothesTypeUC = GetClothesTypes(repository)
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