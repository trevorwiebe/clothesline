package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.uimodel.AddOutfitUiModel
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

    fun onEvent(event: AddClothesWornEvent){
        when(event){
            is AddClothesWornEvent.OnOpenClothesCategory -> {
                state = state.copy(
                    addOutfitUiModelsList = state.addOutfitUiModelsList.map {
                        if(it.clothesCategoryModel.primaryKey == event.addOutfitUiModel.clothesCategoryModel.primaryKey){
                            it.copy(isExpanded = !it.isExpanded)
                        }else it
                    }
                )
            }
        }
    }

    private fun loadClothesTypesAndClothes(){
        manageClothesCategoryUseCases.getClothesCategoriesAndClothesUC()
            .map {
                state = state.copy(
                    addOutfitUiModelsList = it.map { clothesMap ->
                        AddOutfitUiModel(
                            clothesCategoryModel = clothesMap.key,
                            clothesModelList = clothesMap.value
                        )
                    }
                )
            }.launchIn(viewModelScope)
    }
}