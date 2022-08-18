package com.trevorwiebe.clothesline.presentation.ui.screens.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(

): ViewModel(){

    fun onEvent(event: ProfileEvent){
        when(event){
            is ProfileEvent.onAddClothesClicked -> {

            }
        }
    }

}