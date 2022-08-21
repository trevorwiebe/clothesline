package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.ManageClothesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AddClothesViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases,
): ViewModel() {

    private val TAG = "AddClothesViewModel"

    private var getClothesTypes: Job? = null

    var state by mutableStateOf(AddClothesState())
        private set

    init{
        refreshClothesTypes()
    }

    fun onEvent(event: AddClothesEvent){
        when(event){
            is AddClothesEvent.OnClothesSaved -> {

            }
            is AddClothesEvent.OnClothesCategorySelected -> {

            }
        }
    }

    private fun refreshClothesTypes(){
        getClothesTypes?.cancel()
        getClothesTypes = manageClothesCategoryUseCases.getClothesCategoryUC()
            .onEach { clothesCategoryModel ->
                state = state.copy(
                    clothesCategoryList = clothesCategoryModel
                )
            }
            .launchIn(viewModelScope)
    }

}