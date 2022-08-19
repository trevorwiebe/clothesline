package com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.presentation.ui.components.ActionButton
import com.trevorwiebe.clothesline.presentation.ui.components.CustomOutlineTextField
import com.trevorwiebe.clothesline.presentation.ui.screens.viewclothesworn.components.DaySelectorBar
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ViewClothesWornScreen(
    viewModel: ViewClothesWornViewModel = hiltViewModel()
) {

    var state = viewModel.state

    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .padding(spacing.spaceMedium)
    ) {
        DaySelectorBar(viewModel = viewModel)
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        LazyColumn{
            item{
                
            }
        }
    }
}