package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.use_cases.viewclotheswornusecases.ViewClothesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ViewClothesWornViewModel @Inject constructor(
    private val viewClothesUseCases: ViewClothesUseCases
): ViewModel() {

    var state by mutableStateOf(ViewClothesState())

    private var getClothesWornJob: Job? = null

    init {
        loadClothesWorn()
    }

    fun onEvent(event: ViewClothesWornEvent){
        when(event){
            is ViewClothesWornEvent.OnNextDayClick -> {
                state = state.copy(
                    date = state.date.plusDays(1)
                )
                loadClothesWorn()
            }
            is ViewClothesWornEvent.OnDateSelected -> {

            }
            is ViewClothesWornEvent.OnPreviousDayClick -> {
                state = state.copy(
                    date = state.date.minusDays(1)
                )
                loadClothesWorn()
            }
        }
    }

    private fun loadClothesWorn(){
        getClothesWornJob?.cancel()
        getClothesWornJob = viewClothesUseCases
            .getClothesWorn(state.date)
            .onEach {
                state = state.copy(
                    clothesWornList = it
                )
            }
            .launchIn(viewModelScope)
    }
}