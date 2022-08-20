package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.use_cases.manageclothescategory_usecases.ManageClothesCategoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class AddClothesWornViewModel @Inject constructor(
    private val manageClothesCategoryUseCases: ManageClothesCategoryUseCases
): ViewModel() {

    var state by mutableStateOf(AddClothesWornState())

    init {
        loadClothesTypes()
    }

    private fun loadClothesTypes(){
        manageClothesCategoryUseCases.getClothesCategoryUC()
            .map { clothesTypeModelList ->
                state = state.copy(
                    clothesTypeList = clothesTypeModelList
                )
            }
            .launchIn(viewModelScope)
    }
}