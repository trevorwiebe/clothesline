package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn

import java.time.LocalDate

data class AddClothesWornState (
    val date: LocalDate = LocalDate.now()
)