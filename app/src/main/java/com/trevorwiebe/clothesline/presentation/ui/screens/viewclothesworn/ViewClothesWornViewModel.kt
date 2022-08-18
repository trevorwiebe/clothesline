package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.use_cases.viewclotheswornusecases.ViewClothesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ViewClothesWornViewModel @Inject constructor(
    private val viewClothesUseCases: ViewClothesUseCases
): ViewModel() {

    var state by mutableStateOf(ViewClothesState())

    init {
        loadClothesWorn()
    }

    fun onEvent(event: ViewClothesWornEvent){
        when(event){
            is ViewClothesWornEvent.OnNextDayClick -> {

            }
            is ViewClothesWornEvent.OnPreviousDayClick -> {

            }
        }
    }

    private fun loadClothesWorn(){
        viewClothesUseCases
            .getClothesWorn(state.date)
            .onEach {
                state = state.copy(
                    clothesWornList = it
                )
            }
            .launchIn(viewModelScope)
    }
}