package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.domain.use_cases.ParseCurrencyToLong
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import com.trevorwiebe.clothesline.domain.use_cases.manangeclothes_usecases.ManageClothesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddClothesViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases,
    private val manageClothesUC: ManageClothesUseCases,
    private val parseCurrencyToLong: ParseCurrencyToLong
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
                state = state.copy(
                    purchasedPrice = parseCurrencyToLong(event.price)
                )
                Log.d(TAG, "onEvent: " + event.price)
            }
            is AddClothesEvent.OnClothesSaved -> {
                saveClothes(
                    state.selectedClothesCategoryModel.primaryKey,
                    state.name,
                    state.friendlyId,
                    state.datePurchased,
                    state.purchasedPrice)
                state = state.copy(
                    name = "",
                    friendlyId = "",
                    datePurchased = LocalDate.now(),
                    purchasedPrice = 0
                )
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
        val clothesModel = ClothesModel(0, name, clothesTypeId, friendlyId, null, datePurchased, purchasePrice, false)
        viewModelScope.launch {
            manageClothesUC.addClothesUC(clothesModel)
        }
    }
}