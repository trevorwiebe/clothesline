package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothes.AddClothesViewModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.AddClothesWornEvent
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.AddClothesWornViewModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.uimodel.AddOutfitUiModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesTypeList(
    addOutfitUiModel: AddOutfitUiModel,
    onOpenCategoryClick: () -> Unit,
    viewModel: AddClothesWornViewModel
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .clickable { onOpenCategoryClick() }
            .background(MaterialTheme.colors.primaryVariant)
            .padding(spacing.spaceMedium)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(bottom = spacing.spaceSmall),
            text = addOutfitUiModel.clothesCategoryModel.name,
            fontWeight = FontWeight.Bold
        )
        AnimatedVisibility(visible = addOutfitUiModel.isExpanded) {
            Column() {
                addOutfitUiModel.clothesModelList.forEach{ clothesUiModel ->
                    ClothesList(
                        clothesUiModel = clothesUiModel,
                        onCheckedChange = {
                            viewModel.onEvent(AddClothesWornEvent.OnClothesModelSelected(clothesUiModel))
                        }
                    )
                }
            }
        }
    }

}