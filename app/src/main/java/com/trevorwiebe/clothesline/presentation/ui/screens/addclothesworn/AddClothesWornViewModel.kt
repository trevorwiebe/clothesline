package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.model.OutfitModel
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases.OutfitUseCases
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
    private val outfitUseCases: OutfitUseCases
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
                val outfit = OutfitModel(0, LocalDate.now(), false)
                val clothesWornList: MutableList<ClothesWornModel> = mutableListOf()
                state.addOutfitUiModelsList.map { addOutfitUiModel ->
                    for (clothesModel in addOutfitUiModel.clothesModelList){
                        if(clothesModel.isChecked) {
                            val clothesWornModel = ClothesWornModel(
                                0,
                                clothesModel.clothesModel.primaryKey,
                                74,
                                LocalDate.now(),
                                false
                            )
                            clothesWornList.add(clothesWornModel)
                        }
                    }
                }
                saveOutfitAndClothesWornList(outfit, clothesWornList)
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

    private fun saveOutfitAndClothesWornList(outfitModel: OutfitModel, clothesWornModelList: List<ClothesWornModel>){
        viewModelScope.launch {
            outfitUseCases.insertOutfitAndClothesWornListUC(outfitModel, clothesWornModelList)
        }
    }
}