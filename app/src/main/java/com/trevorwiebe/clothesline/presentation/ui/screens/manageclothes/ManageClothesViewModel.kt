package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases.ManageClothesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageClothesViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases,
    private val manageClothesUseCases: ManageClothesUseCases
): ViewModel() {

    private var getClothesTypes: Job? = null

    var state by mutableStateOf(ManageClothesState())
        private set

    init{
        refreshClothesTypes()
        getClothesByClothesTypeId(state.selectedClothesCategory.primaryKey)
    }

    fun onEvent(event: ManageClothesEvent){
        when(event){
            is ManageClothesEvent.OnClothesCategorySelected -> {
                state = state.copy(
                    selectedClothesCategory = event.clothesCategoryModel
                )
                getClothesByClothesTypeId(state.selectedClothesCategory.primaryKey)
            }
            is ManageClothesEvent.OnAddClothesClicked -> {

            }
        }
    }

    private fun refreshClothesTypes(){
        getClothesTypes?.cancel()
        getClothesTypes = manageClothesCategoryUseCases.getClothesCategoryUC()
            .onEach { clothesCategoryModel ->
                state = state.copy(
                    clothesCategoryList = clothesCategoryModel,
                    selectedClothesCategory = clothesCategoryModel[0]
                )
                getClothesByClothesTypeId(state.selectedClothesCategory.primaryKey)
            }
            .launchIn(viewModelScope)
    }

    private fun getClothesByClothesTypeId(id: Int){
        manageClothesUseCases.getClothesByClothesCategoryIdUC(id)
            .onEach { clothesModelsList ->
                state = state.copy(
                    clothesList = clothesModelsList
                )
                calculateClothesWorth(clothesModelsList)
            }
            .launchIn(viewModelScope)
    }

    private fun calculateClothesWorth(clothesList: List<ClothesModel>){
        val worth = manageClothesUseCases.calculateClothesWorthUC(clothesList)
        state = state.copy(
            clothesWorth = worth
        )
    }

}