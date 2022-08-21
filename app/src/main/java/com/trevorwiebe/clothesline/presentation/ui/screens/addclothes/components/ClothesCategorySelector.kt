package com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.AddClothesEvent
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.AddClothesState
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.AddClothesViewModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesCategorySelector(
    viewModel: AddClothesViewModel = hiltViewModel(),
    onOpen: () -> Unit
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .background(if (viewModel.state.isClothesCategoryOpen) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.background)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onOpen() }
                .border(
                    width = 1.dp,
                    color = if (viewModel.state.isClothesCategoryOpen) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.onBackground,
                    shape = RoundedCornerShape(spacing.radius_two)
                )
                .padding(spacing.spaceMedium),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = viewModel.state.selectedClothesCategoryModel.name
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Select Clothes Category"
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        AnimatedVisibility(visible = viewModel.state.isClothesCategoryOpen) {
            Column(
                modifier = Modifier.padding(bottom = spacing.spaceSmall)
            ) {
            viewModel.state.clothesCategoryList.forEach{ clothesCategoryModel ->
                Row(
                    modifier = Modifier
                        .clickable { viewModel.onEvent(AddClothesEvent.OnClothesCategorySelected(clothesCategoryModel)) }
                        .fillMaxWidth()
                        .padding(
                            top = spacing.spaceSmall,
                            bottom = spacing.spaceSmall,
                            start = spacing.spaceMedium,
                            end = spacing.spaceSmall
                        )
                ) {
                    Text(text = clothesCategoryModel.name)
                    }
                }
            }
        }
    }
}