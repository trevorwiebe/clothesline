package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases.ManageClothesUseCases
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.uimodel.ClothesUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class AddClothesWornViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases,
): ViewModel() {

    var state by mutableStateOf(AddClothesWornState())

    init {
        loadClothesTypesAndClothes()
    }

    private fun loadClothesTypesAndClothes(){
        manageClothesCategoryUseCases.getClothesCategoriesAndClothesUC()
            .map {
                state = state.copy(
                    clothesUiModelsList = it.map { clothesMap ->
                        ClothesUiModel(
                            clothesCategoryModel = clothesMap.key,
                            clothesModelList = clothesMap.value
                        )
                    }
                )
            }.launchIn(viewModelScope)
    }
}