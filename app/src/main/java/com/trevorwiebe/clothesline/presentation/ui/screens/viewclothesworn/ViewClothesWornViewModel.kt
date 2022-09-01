package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trevorwiebe.clothesline.domain.use_cases.outfit_usecases.OutfitUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ViewClothesWornViewModel @Inject constructor(
    private val outfitUseCases: OutfitUseCases
): ViewModel() {

    var state by mutableStateOf(ViewClothesState())

    private var loadOutfitsJob: Job? = null

    init {
        loadOutfitsByDate(state.date)
    }

    fun onEvent(event: ViewClothesWornEvent){
        when(event){
            is ViewClothesWornEvent.OnNextDayClick -> {
                state = state.copy(
                    date = state.date.plusDays(1)
                )
                loadOutfitsByDate(state.date)
            }
            is ViewClothesWornEvent.OnDateSelected -> {

            }
            is ViewClothesWornEvent.OnPreviousDayClick -> {
                state = state.copy(
                    date = state.date.minusDays(1)
                )
                loadOutfitsByDate(state.date)
            }
        }
    }

    private fun loadOutfitsByDate(date: LocalDate){
        loadOutfitsJob?.cancel()
        loadOutfitsJob = outfitUseCases.getOutfitsByDateUC(date)
            .map {
                state = state.copy(
                    outfitList = it
                )
            }
            .launchIn(viewModelScope)
    }

}