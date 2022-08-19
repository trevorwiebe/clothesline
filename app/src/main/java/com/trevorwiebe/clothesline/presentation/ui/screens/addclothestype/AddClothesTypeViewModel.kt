package com.trevorwiebe.clothesline.presentation.ui.screens.addclothestype

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.core.util.UiEvent
import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.use_cases.addclothestypeusecases.AddClothesTypeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddClothesTypeViewModel @Inject constructor(
    private val addClothesTypeUseCases: AddClothesTypeUseCases
): ViewModel() {

    val TAG = "AddClothesTypeViewModel"

    var state by mutableStateOf(AddClothesTypeState())
        private set

    private var getClothesTypes: Job? = null

    init {
        refreshClothsTypes()
    }

    fun onEvent(event: AddClothesTypeEvent){
        when(event){
            is AddClothesTypeEvent.OnClothesTypeAdded -> {
                addClothesType()
            }
            is AddClothesTypeEvent.OnClothesTypeChange -> {
                state = state.copy(
                    clothesTypeString = event.name
                )
            }
            is AddClothesTypeEvent.OnClothesTypeDelete -> {
                deleteClothesType(event.clothesTypeModel)
            }
        }
    }

    private fun addClothesType(){
        viewModelScope.launch {
            addClothesTypeUseCases.addClothesTypeUC(
                name = state.clothesTypeString
            )
        }
    }

    private fun deleteClothesType(clothesTypeModel: ClothesTypeModel){
        viewModelScope.launch {
            addClothesTypeUseCases.deleteClothesTypeUC(
                clothesTypeModel = clothesTypeModel
            )
        }
    }

    private fun refreshClothsTypes(){
        getClothesTypes?.cancel()
        getClothesTypes = addClothesTypeUseCases.getClothesTypeUC()
            .onEach { clothesModel ->
                state = state.copy(
                    clothesTypesList = clothesModel,
                    clothesTypeString = ""
                )
            }
            .launchIn(viewModelScope)
    }
}