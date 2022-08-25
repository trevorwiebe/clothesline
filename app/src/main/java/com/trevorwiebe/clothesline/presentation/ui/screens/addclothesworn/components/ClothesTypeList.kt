package com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.trevorwiebe.clothesline.domain.model.ClothesCategoryModel
import com.trevorwiebe.clothesline.domain.model.ClothesModel
import com.trevorwiebe.clothesline.presentation.ui.screens.addclothesworn.AddClothesWornViewModel
import com.trevorwiebe.clothesline.presentation.ui.screens.manageclothes.uimodel.ClothesUiModel
import com.trevorwiebe.clothesline.presentation.ui.theme.LocalSpacing

@Composable
fun ClothesTypeList(
    clothesUiModel: ClothesUiModel
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(spacing.radius_two))
            .clickable { }
            .background(MaterialTheme.colors.primaryVariant)
            .padding(spacing.spaceMedium)
            .fillMaxWidth()
    ) {
        Text(
            text = clothesUiModel.clothesCategoryModel.name
        )
        AnimatedVisibility(visible = clothesUiModel.isExpanded) {
            Log.d("TAG2", "ClothesTypeList: " + clothesUiModel.clothesModelList)
            Column() {
                clothesUiModel.clothesModelList.forEach{ clothesModel ->
                    Text(text = clothesModel.name)
                }
            }
        }
    }

}