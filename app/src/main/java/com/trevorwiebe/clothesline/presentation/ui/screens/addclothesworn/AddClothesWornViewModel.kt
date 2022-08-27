package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.use_cases.addclothesworn_usecases.AddClothesWornUseCases
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel.AddClothesUiModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel.AddOutfitUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddClothesWornViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases,
    private val addClothesWornUseCases: AddClothesWornUseCases
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
            is AddClothesWornEvent.OnClothesModelSelected -> {
                state = state.copy(
                    addOutfitUiModelsList = state.addOutfitUiModelsList.map { addOutfitUiModel ->
                        addOutfitUiModel.copy(clothesModelList = addOutfitUiModel.clothesModelList.map{
                            if(it.clothesModel.primaryKey == event.addClothesUiModel.clothesModel.primaryKey) {
                                if (!it.isChecked) saveClothesWorn(it.clothesModel)
                                else removeClothesWorn(it.clothesModel)
                                it.copy(isChecked = !it.isChecked)
                            }else it
                        })
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
                            clothesModelList = clothesMap.value.map { clothesModel ->
                                AddClothesUiModel(clothesModel, false)
                            }
                        )
                    }
                )
            }.launchIn(viewModelScope)
    }

    private fun saveClothesWorn(clothesModel: ClothesModel){
        viewModelScope.launch {
            val clothesWornModel: ClothesWornModel = ClothesWornModel(
                0,
                clothesModel.primaryKey,
                0
            )
            addClothesWornUseCases.addClothesWornUC(clothesWornModel)
        }
    }

    private fun removeClothesWorn(clothesModel: ClothesModel){
        viewModelScope.launch {
            val clothesWornModel: ClothesWornModel = ClothesWornModel(
                0,
                clothesModel.primaryKey,
                0
            )
            addClothesWornUseCases.deleteClothesWornUC(clothesWornModel)
        }
    }
}