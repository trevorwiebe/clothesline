package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.use_cases.manageclothesworn_usecases.ManageClothesWornUseCases
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel.AddClothesUiModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel.AddOutfitUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddClothesWornViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases,
    private val manageClothesWornUseCases: ManageClothesWornUseCases
): ViewModel() {

    private val TAG = "AddClothesWornViewModel"

    var state by mutableStateOf(AddClothesWornState())

    init {
        loadClothesTypesAndClothes()
    }

    fun onEvent(event: AddClothesWornEvent) {
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
                                it.copy(isChecked = !it.isChecked)
                            }else it
                        })
                    }
                )
            }
            is AddClothesWornEvent.OnSaveOutfit -> {
                val clothesWornList: MutableList<ClothesWornModel> = mutableListOf()
                state.addOutfitUiModelsList.map { addOutfitUiModel ->
                    for (clothesModel in addOutfitUiModel.clothesModelList){
                        Log.d(TAG, "onEvent: " + clothesModel.isChecked)
                        if(clothesModel.isChecked) {
                            val clothesWornModel = ClothesWornModel(
                                0,
                                clothesModel.clothesModel.primaryKey,
                                LocalDate.now(),
                                false
                            )
                            clothesWornList.add(clothesWornModel)
                        }
                    }
                }
                saveClothesWornList(clothesWornList)
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

    private fun saveClothesWornList(clothesWornModelList: List<ClothesWornModel>){
        viewModelScope.launch {
            manageClothesWornUseCases.addClothesWornListUC(clothesWornModelList)
        }
    }

    private fun removeClothesWorn(clothesModel: ClothesModel){
        viewModelScope.launch {
            val clothesWornModel = ClothesWornModel(
                0,
                clothesModel.primaryKey,
                LocalDate.now(),
                false
            )
            manageClothesWornUseCases.deleteClothesWornUC(clothesWornModel)
        }
    }
}