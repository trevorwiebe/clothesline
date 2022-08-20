package com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageClothesViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases
): ViewModel() {

    private var getClothesTypes: Job? = null

    var state by mutableStateOf(ManageClothesState())
        private set

    init{
        refreshClothesTypes()
    }

    fun onEvent(event: ManageClothesEvent){
        when(event){
            is ManageClothesEvent.OnClothesCategorySelected -> {
                state = state.copy(
                    selectedClothesCategory = event.clothesCategoryModel
                )
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
            }
            .launchIn(viewModelScope)
    }

    private fun refreshClothes(){

    }

}