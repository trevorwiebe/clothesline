package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

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
    private val manageClothesUseCases: ManageClothesUseCases
): ViewModel() {

    var state by mutableStateOf(AddClothesWornState())

    init {
        loadClothesTypes()
        loadClothes()
    }

    private fun loadClothesTypes(){
        manageClothesCategoryUseCases.getClothesCategoryUC()
            .map { clothesTypeModelList ->
                state = state.copy(
                    clothesUiModelsList = clothesTypeModelList.map {
                        ClothesUiModel(
                            clothesCategoryModel = it,
                            clothesModelList = emptyList()
                        )
                    }
                )
            }
            .launchIn(viewModelScope)
    }
    private fun loadClothes(){
        manageClothesUseCases.getClothesUC()
            .map { clothesModelList ->
                state = state.copy(

                )
            }
            .launchIn(viewModelScope)
    }
}