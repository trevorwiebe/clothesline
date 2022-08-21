package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothescategory

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageClothesCategoryViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases
): ViewModel() {

    val TAG = "AddClothesTypeViewModel"

    var state by mutableStateOf(ManageClothesCategoryState())
        private set

    private var getClothesTypes: Job? = null

    init {
        refreshClothsTypes()
    }

    fun onEvent(event: ManageClothesCategoryEvent){
        when(event){
            is ManageClothesCategoryEvent.OnClothesCategoryAdded -> {
                addClothesType()
            }
            is ManageClothesCategoryEvent.OnClothesCategoryChange -> {
                state = state.copy(
                    clothesTypeString = event.name
                )
            }
            is ManageClothesCategoryEvent.OnClothesCategoryDelete -> {
                deleteClothesType(event.clothesCategoryModel)
            }
        }
    }

    private fun addClothesType(){
        viewModelScope.launch {
            manageClothesCategoryUseCases.addClothesCategoryUC(
                name = state.clothesTypeString
            )
        }
    }

    private fun deleteClothesType(clothesCategoryModel: ClothesCategoryModel){
        viewModelScope.launch {
            manageClothesCategoryUseCases.deleteClothesCategoryUC(
                clothesCategoryModel = clothesCategoryModel
            )
        }
    }

    private fun refreshClothsTypes(){
        getClothesTypes?.cancel()
        getClothesTypes = manageClothesCategoryUseCases.getClothesCategoryUC()
            .onEach { clothesModel ->
                state = state.copy(
                    clothesTypesList = clothesModel,
                    clothesTypeString = ""
                )
            }
            .launchIn(viewModelScope)
    }
}