package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.presentation.ui.components.CustomOutlineTextField
import com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn.components.DaySelectorBar

@Composable
fun ViewClothesWornScreen(
    viewModel: ViewClothesWornViewModel = hiltViewModel()
) {

    var state = viewModel.state

    DaySelectorBar(viewModel = viewModel)

}