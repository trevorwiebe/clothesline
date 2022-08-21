package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases.GetClothesUC
import com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases.ManageClothesUseCases
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.ManageClothesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddClothesViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases,
    private val manageClothesUC: ManageClothesUseCases
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
            is AddClothesEvent.OnNameChanged -> {
                state = state.copy(name = event.name)
            }
            is AddClothesEvent.OnIdChanged -> {
                state = state.copy(friendlyId = event.friendlyId)
            }
            is AddClothesEvent.OnDateChanged -> {
            }
            is AddClothesEvent.OnPurchasePriceChanged -> {
            }
            is AddClothesEvent.OnClothesSaved -> {
                saveClothes(
                    state.selectedClothesCategoryModel.primaryKey!!,
                    state.name,
                    state.friendlyId,
                    state.datePurchased,
                    state.purchasedPrice)
            }
            is AddClothesEvent.OnClothesCategorySelected -> {
                state = state.copy(
                    selectedClothesCategoryModel = event.clothesCategoryModel,
                    isClothesCategoryOpen = !state.isClothesCategoryOpen
                )
            }
            is AddClothesEvent.OnOpenClothesCategorySelector -> {
                state = state.copy(
                    isClothesCategoryOpen = !state.isClothesCategoryOpen
                )
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

    private fun saveClothes(clothesTypeId: Int, name: String, friendlyId: String, datePurchased: LocalDate, purchasePrice: Long){
        val clothesModel = ClothesModel(null, name, clothesTypeId, friendlyId, null, datePurchased, purchasePrice)
        viewModelScope.launch {
            manageClothesUC.addClothesUC(clothesModel)
        }
    }

}