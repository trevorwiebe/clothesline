package com.trevorwiebe.clothesline.domain.di

import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases.AddClothesTypeUC
import com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases.AddClothesTypeUseCases
import com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases.DeleteClothesTypeUC
import com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases.GetClothesTypeUC
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
    fun provideClothesLine_AddClothesUseCases(
        repository: ClothesLineRepository
    ): AddClothesTypeUseCases {
        return AddClothesTypeUseCases(
            addClothesTypeUC = AddClothesTypeUC(repository),
            getClothesTypeUC = GetClothesTypeUC(repository),
            deleteClothesTypeUC = DeleteClothesTypeUC(repository)
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