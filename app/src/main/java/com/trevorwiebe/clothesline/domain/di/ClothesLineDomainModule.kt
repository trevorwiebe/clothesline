package com.trevorwiebe.clothesline.domain.di

import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases.AddClothesTypeUC
import com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases.AddClothesUseCases
import com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases.GetClothesTypes
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
    fun provideClothesLineUseCases(
        repository: ClothesLineRepository
    ): AddClothesUseCases {
        return AddClothesUseCases(
            addClothesTypeUC = AddClothesTypeUC(repository),
            getClothesTypeUC = GetClothesTypes(repository)
        )
    }
}